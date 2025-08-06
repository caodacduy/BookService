package com.example.BookService.controller;

import com.example.BookService.dto.request.LoginRequest;
import com.example.BookService.dto.request.UserRequest;
import com.example.BookService.dto.response.ApiResponse;
import com.example.BookService.dto.response.AuthenticationResponse;
import com.example.BookService.dto.response.UserResponse;
import com.example.BookService.service.AuthenticateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Slf4j(topic = "AUTHENTICATION-CONTROLLER")
@RequiredArgsConstructor
public class AuthenticationController {
    final AuthenticateService authenticationService;

    @PostMapping("/log-in")
    ApiResponse<AuthenticationResponse> getAccessToken(@RequestBody LoginRequest request){
        log.info("Access token request{}",request.getUsername());
        return ApiResponse.<AuthenticationResponse>builder()
                .result(authenticationService.authenticateUser(request))
                .build();
    }

    @PostMapping("/sign-up")
    ApiResponse<UserResponse> signUp(@RequestBody UserRequest request){
        log.info("SignUp request{}",request.getUsername());
        return ApiResponse.<UserResponse>builder()
                .result(authenticationService.registerUser(request))
                .build();
    }



}
