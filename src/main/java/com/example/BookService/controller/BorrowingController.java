package com.example.BookService.controller;

import com.example.BookService.dto.request.UpdateStatusBorrowingRequest;
import com.example.BookService.dto.request.BorrowingRequest;
import com.example.BookService.dto.response.ApiResponse;
import com.example.BookService.dto.response.BorrowingResponse;
import com.example.BookService.dto.response.BorrowingUserIdResponse;
import com.example.BookService.service.BorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
@RequiredArgsConstructor
public class BorrowingController {
    final BorrowingService borrowingService;

    @PostMapping("")
    ApiResponse<BorrowingResponse> borrow(@RequestBody BorrowingRequest request){
        return ApiResponse.<BorrowingResponse>builder()
                .result(borrowingService.borrow(request))
                .build();
    }

    @PutMapping("/{id}")
    ApiResponse<BorrowingResponse> updateStatus(@PathVariable int id,@RequestBody UpdateStatusBorrowingRequest request){
        return ApiResponse.<BorrowingResponse>builder()
                .result(borrowingService.updateStatus(id,request))
                .build();
    }

    @GetMapping("/users/{id}/borrowed-books")
    ApiResponse<List<BorrowingUserIdResponse>> getBorrowingByUserId(@PathVariable int id){
        return ApiResponse.<List<BorrowingUserIdResponse>>builder()
                .result(borrowingService.getAllBorrowById(id))
                .build();
    }
}
