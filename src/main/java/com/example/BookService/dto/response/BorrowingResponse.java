package com.example.BookService.dto.response;

import com.example.BookService.entity.Book;
import com.example.BookService.entity.User;
import com.example.BookService.enumType.BorrowStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingResponse {
    private int id;
    private UserResponse user;
    private BookResponse book;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private BorrowStatus status;

}
