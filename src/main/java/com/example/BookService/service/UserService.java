package com.example.BookService.service;

import com.example.BookService.dto.request.UserRequest;
import com.example.BookService.dto.response.UserResponse;
import com.example.BookService.entity.User;
import com.example.BookService.exception.AppException;
import com.example.BookService.exception.ErrorCode;
import com.example.BookService.mapper.UserMapper;
import com.example.BookService.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;


    public UserResponse createUser(UserRequest request){
        if (userRepository.existsByEmail(request.getEmail())) throw new AppException(ErrorCode.USER_EXISTED);

        if (request.getPassword().length()<8) throw new AppException(ErrorCode.INVALID_PASSWORD);

        User user=userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userMapper.toUserResponse(userRepository.save(user));
    }
    public List<UserResponse> getUser(){
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

//    public UserDetailsService userDetailsService(){
//        return username -> userRepository.findByEmail(username).orElseThrow(new UsernameNotFoundException("User not found"));
//    }
}
