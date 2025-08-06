package com.example.BookService.service;



import com.example.BookService.dto.request.LoginRequest;
import com.example.BookService.dto.request.UserRequest;
import com.example.BookService.dto.response.AuthenticationResponse;
import com.example.BookService.dto.response.UserResponse;
import com.example.BookService.entity.Role;
import com.example.BookService.entity.User;
import com.example.BookService.entity.UserDetailsImpl;
import com.example.BookService.enumType.ERole;
import com.example.BookService.exception.AppException;
import com.example.BookService.exception.ErrorCode;
import com.example.BookService.mapper.UserMapper;
import com.example.BookService.repository.RoleRepository;
import com.example.BookService.repository.UserRepository;
import com.example.BookService.security.JwtUtils;
import jakarta.validation.Valid;
import lombok.AccessLevel;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.Set;


@Slf4j(topic = "AUTHENTICATE-SERVICE")
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticateService {
    AuthenticationManager authenticationManager;

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    RoleRepository roleRepository;

    JwtUtils jwtUtils;

    public AuthenticationResponse authenticateUser(LoginRequest request){
        log.info("authenticateUser {}",request.getUsername());
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt=jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails =(UserDetailsImpl) authentication.getPrincipal();

        return AuthenticationResponse.builder()
                .token(jwt)
                .email(userDetails.getEmail())
                .id((int) userDetails.getId())
                .username(userDetails.getUsername())
                .build();

    }

    public UserResponse registerUser(@Valid @RequestBody UserRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        User user=userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Set<String> strRoles = request.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new AppException(ErrorCode.BORROW_EN));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;

                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);


        return userMapper.toUserResponse(userRepository.save(user));
    }
}
