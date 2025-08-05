package com.example.BookService.dto.response;


import com.example.BookService.entity.Author;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private int id;
    private String title;
    private String publisher;
    private String category;
    private String isbn;
    private String authorName;
}
