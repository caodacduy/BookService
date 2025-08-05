package com.example.BookService.dto.request;


import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRequest {
    @NotEmpty(message = "NOT_NULL")
    private String title;

    private String publisher;

    @NotEmpty(message = "NOT_NULL")
    private String category;
    @NotEmpty(message = "NOT_NULL")
    private String isbn;
    private int id_author;
}
