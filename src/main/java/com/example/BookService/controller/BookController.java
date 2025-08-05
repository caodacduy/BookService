package com.example.BookService.controller;

import com.example.BookService.dto.request.BookRequest;
import com.example.BookService.dto.response.ApiResponse;
import com.example.BookService.dto.response.BookResponse;
import com.example.BookService.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    final BookService bookService;

    @PostMapping("")
    ApiResponse<BookResponse> createBook(@Valid @RequestBody BookRequest request) {
        return ApiResponse.<BookResponse>builder()
                .result(bookService.createBook(request))
                .build();
    }

    @GetMapping("")
    ApiResponse<List<BookResponse>>getAllBook(){
        return ApiResponse.<List<BookResponse>>builder()
                .result(bookService.getAllBooks())
                .build();
    }

    @GetMapping("{id}")
    ApiResponse<BookResponse>getBookById(@PathVariable int id){
        return ApiResponse.<BookResponse>builder()
                .result(bookService.getBookById(id))
                .build();
    }

    @PutMapping("/{id}")
    ApiResponse<BookResponse> UpdateBook(@PathVariable int id ,@RequestBody BookRequest request){
        return ApiResponse.<BookResponse>builder()
                .result(bookService.updateBook(id,request))
                .build();
    }

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable int id){bookService.deleteBook(id);}
}
