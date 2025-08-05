package com.example.BookService.dto.request;


import com.example.BookService.enumType.BorrowStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStatusBorrowingRequest {
    private BorrowStatus status;
}
