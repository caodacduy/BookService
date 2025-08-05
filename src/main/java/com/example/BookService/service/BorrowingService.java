package com.example.BookService.service;

import com.example.BookService.dto.request.UpdateStatusBorrowingRequest;
import com.example.BookService.dto.request.BorrowingRequest;

import com.example.BookService.dto.response.BorrowingResponse;
import com.example.BookService.dto.response.BorrowingUserIdResponse;
import com.example.BookService.entity.Book;
import com.example.BookService.entity.Borrowing;
import com.example.BookService.entity.User;

import com.example.BookService.exception.AppException;
import com.example.BookService.exception.ErrorCode;
import com.example.BookService.mapper.BookMapper;
import com.example.BookService.mapper.BorrowingMapper;
import com.example.BookService.mapper.UserMapper;
import com.example.BookService.repository.BookRepository;
import com.example.BookService.repository.BorrowingRepository;
import com.example.BookService.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BorrowingService {
    BorrowingMapper borrowingMapper;
    BorrowingRepository borrowingRepository;
    UserRepository userRepository;
    BookRepository bookRepository;
    UserMapper userMapper;
    BookMapper bookMapper;

    public BorrowingResponse borrow(BorrowingRequest request){
        if (checkBorrowingStatus(request.getBookId()).equals("BORROWED")){
            throw new AppException(ErrorCode.BORROW_EN);
        }
        User user=userRepository.findById(request.getUserId()).orElseThrow(()->new AppException(ErrorCode.USER_NOT_EXISTED));
        Book book=bookRepository.findById(request.getBookId()).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));

        Borrowing borrowing=borrowingMapper.toBorrowing(request);
        borrowing.setUser(user);
        borrowing.setBook(book);
        LocalDate borrowDate=LocalDate.now();
        borrowing.setBorrowDate(borrowDate);

        if (borrowDate.isAfter(borrowing.getReturnDate())){
            throw new AppException(ErrorCode.DATE_FAIL);
        }

        BorrowingResponse borrowingResponse=borrowingMapper.toBorrowingResponse(borrowingRepository.save(borrowing));
        borrowingResponse.setUser(userMapper.toUserResponse(user));
        borrowingResponse.setBook(bookMapper.toBookResponse(book));
        return borrowingResponse;
    }

    public String checkBorrowingStatus(int bookId) {
        Optional<Borrowing> latestBorrowing = borrowingRepository.findTopByBookIdOrderByBorrowDateDesc(bookId);

        if (latestBorrowing.isEmpty()) {
            return "";
        }

        Borrowing borrowing = latestBorrowing.get();
        System.out.println(borrowing.getStatus().name());
        return borrowing.getStatus().name();
    }

    public BorrowingResponse updateStatus(int id, UpdateStatusBorrowingRequest request){
        Borrowing borrowing=borrowingRepository.findById(id).orElseThrow(()->new AppException(ErrorCode.USER_NOT_EXISTED));
        borrowingMapper.updateStatus(borrowing,request);
        return borrowingMapper.toBorrowingResponse(borrowingRepository.save(borrowing));

    }

    public List<BorrowingUserIdResponse> getAllBorrowById(int id){
        List<Borrowing> borrowings=borrowingRepository.findAllByUser_Id(id);

        return borrowings.stream()
                .map(borrowingMapper::toBorrowingUserIdResponse)
                .toList();
    }
}
