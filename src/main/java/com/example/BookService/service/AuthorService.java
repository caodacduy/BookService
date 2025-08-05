package com.example.BookService.service;

import com.example.BookService.dto.request.AuthorRequest;
import com.example.BookService.dto.response.AllAuthorResponse;
import com.example.BookService.dto.response.AuthorResponse;
import com.example.BookService.dto.response.BookResponse;
import com.example.BookService.entity.Author;
import com.example.BookService.exception.AppException;
import com.example.BookService.exception.ErrorCode;
import com.example.BookService.mapper.AuthorMapper;
import com.example.BookService.mapper.BookMapper;
import com.example.BookService.repository.AuthorRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorService {
    private final BookMapper bookMapper;
    AuthorMapper authorMapper;
    AuthorRepository authorRepository;

    public List<AllAuthorResponse> getAllAuthor(){
        return authorRepository.findAll().stream()
                .map(authorMapper::toAllAuthorResponse)
                .toList();
    }

    public AuthorResponse createAuthor(AuthorRequest authorRequest){
        Author author=authorMapper.toAuthor(authorRequest);
        return authorMapper.toAuthorResponse(authorRepository.save(author));
    }

    public  AuthorResponse getAuthorInfo(int id){
        Author author=authorRepository.findById(id).orElseThrow(()->new AppException(ErrorCode.USER_NOT_EXISTED));
        log.info(author.getBooks().toString());
        List<BookResponse> bookResponses= author.getBooks().stream()
                .map(bookMapper::toBookResponse)
                .toList();
        AuthorResponse authorResponse= authorMapper.toAuthorResponse(author);
        authorResponse.setBooks(bookResponses);
        return authorResponse;
    }
}
