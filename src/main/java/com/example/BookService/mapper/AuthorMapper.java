package com.example.BookService.mapper;

import com.example.BookService.dto.request.AuthorRequest;
import com.example.BookService.dto.response.AllAuthorResponse;
import com.example.BookService.dto.response.AuthorResponse;
import com.example.BookService.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author toAuthor(AuthorRequest request);

    AuthorResponse toAuthorResponse(Author author);

    AllAuthorResponse toAllAuthorResponse(Author author);
}
