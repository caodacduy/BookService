package com.example.BookService.mapper;

import com.example.BookService.dto.request.BookRequest;
import com.example.BookService.dto.response.BookResponse;
import com.example.BookService.entity.Author;
import com.example.BookService.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toBook(BookRequest bookRequest);

    @Mapping(source = "author.author", target = "authorName")
    BookResponse toBookResponse(Book book);

    default String mapAuthorToString(Author author) {
        return author != null ? author.getAuthor() : null;
    }

    void updateBook(@MappingTarget Book book, BookRequest request);

}
