package com.example.BookService.dto.request;


import com.example.BookService.entity.Book;
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
public class BorrowingRequest {
    private int userId;
    private int bookId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private BorrowStatus status;
}
