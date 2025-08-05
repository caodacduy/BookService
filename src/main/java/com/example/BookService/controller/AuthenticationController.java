package com.example.BookService.controller;

import com.example.BookService.dto.request.AuthenticationRequest;
import com.example.BookService.dto.request.IntrospectRequest;
import com.example.BookService.dto.response.ApiResponse;
import com.example.BookService.dto.response.AuthenticationResponse;
import com.example.BookService.dto.response.IntrospectResponse;
import com.example.BookService.service.AuthenticateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/auth")
//@Slf4j(topic = "AUTHENTICATION-CONTROLLER")
//@RequiredArgsConstructor
//public class AuthenticationController {
//    final AuthenticateService authenticationService;
//
//    @PostMapping("/access-token")
//    ApiResponse<AuthenticationResponse> getAccessToken(@RequestBody AuthenticationRequest request){
//        log.info("Access token request");
//        return ApiResponse.<AuthenticationResponse>builder()
//                .result(authenticationService.authentication(request))
//                .build();
//    }
//
//    @PostMapping("/refresh-token")
//    ApiResponse<AuthenticationResponse> getRefreshToken(@RequestBody AuthenticationRequest request){
//        log.info("Refresh token request");
//        return ApiResponse.<AuthenticationResponse>builder()
////                .result(authenticationService.authentication(request))
//                .build();
//    }
//
//    @PostMapping("/introspect")
//    ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request){
//        return ApiResponse.<IntrospectResponse>builder()
//                .result(authenticationService.introspect(request))
//                .build();
//    }
//
//
//}
