package com.example.BookService.controller;

import com.example.BookService.dto.request.AuthorRequest;
import com.example.BookService.dto.response.AllAuthorResponse;
import com.example.BookService.dto.response.ApiResponse;
import com.example.BookService.dto.response.AuthorResponse;
import com.example.BookService.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    final AuthorService authorService;

    @PostMapping("")
    ApiResponse<AuthorResponse> createAuthor(@RequestBody AuthorRequest request){
        return  ApiResponse.<AuthorResponse>builder()
                .result(authorService.createAuthor(request))
                .build();
    }

    @GetMapping("")
    ApiResponse<List<AllAuthorResponse>>  getAllAuthor(){
        return ApiResponse.<List<AllAuthorResponse>>builder()
                .result(authorService.getAllAuthor())
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<AuthorResponse> getAuthor(@PathVariable int id){
        return ApiResponse.<AuthorResponse>builder()
                .result(authorService.getAuthorInfo(id))
                .build();
    }
}
