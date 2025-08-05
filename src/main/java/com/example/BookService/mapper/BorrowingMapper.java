package com.example.BookService.mapper;

import com.example.BookService.dto.request.UpdateStatusBorrowingRequest;
import com.example.BookService.dto.request.BorrowingRequest;
import com.example.BookService.dto.response.BorrowingResponse;
import com.example.BookService.dto.response.BorrowingUserIdResponse;
import com.example.BookService.entity.Borrowing;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BorrowingMapper {
    BorrowingResponse toBorrowingResponse(Borrowing borrowing);
    BorrowingUserIdResponse toBorrowingUserIdResponse(Borrowing borrowing);

    Borrowing toBorrowing(BorrowingRequest request);

    void updateStatus(@MappingTarget Borrowing borrowing, UpdateStatusBorrowingRequest request);
}
