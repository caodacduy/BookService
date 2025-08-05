package com.example.BookService.service;

import com.example.BookService.dto.request.BookRequest;
import com.example.BookService.dto.response.BookResponse;
import com.example.BookService.entity.Author;
import com.example.BookService.entity.Book;
import com.example.BookService.exception.AppException;
import com.example.BookService.exception.ErrorCode;
import com.example.BookService.mapper.BookMapper;
import com.example.BookService.repository.AuthorRepository;
import com.example.BookService.repository.BookRepository;
import com.example.BookService.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BookService {
    BookRepository bookRepository;
    BookMapper bookMapper;
    AuthorRepository authorRepository;
    private final UserRepository userRepository;


    public  BookResponse createBook(BookRequest request){
        Author author=authorRepository.findById(request.getId_author()).orElseThrow(()->new AppException(ErrorCode.USER_NOT_EXISTED));
        log.info(author.getAuthor());
        Book book=bookMapper.toBook(request);
        book.setAuthor(author);
        BookResponse bookResponse=bookMapper.toBookResponse(bookRepository.save(book));
        bookResponse.setAuthorName(author.getAuthor());
        return bookResponse;
    }
    public  List<BookResponse> getAllBooks(){
        return bookRepository.findAll().stream()
                                    .map(bookMapper::toBookResponse)
                                    .toList();

    }
    public BookResponse getBookById(int id){
        return bookMapper.toBookResponse(
                bookRepository.findById(id).orElseThrow(()->new AppException(ErrorCode.USER_NOT_EXISTED)));
    }
    public BookResponse updateBook(int id,BookRequest request){
        Book book=bookRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        bookMapper.updateBook(book,request);

        return bookMapper.toBookResponse(bookRepository.save(book));
    }

    public void deleteBook(int id){
        userRepository.deleteById(String.valueOf(id));
    }
}
