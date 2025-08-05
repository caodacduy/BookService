package com.example.BookService.controller;

import com.example.BookService.dto.request.UserRequest;
import com.example.BookService.dto.response.ApiResponse;
import com.example.BookService.dto.response.UserResponse;
import com.example.BookService.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @PostMapping("")
    ApiResponse<UserResponse> createUser(@Valid @RequestBody UserRequest request){
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .build();
    }
    @GetMapping("")
    ApiResponse<List<UserResponse>> getUsers(){
        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getUser())
                .build();
    }

}
