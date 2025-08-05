package com.example.BookService.dto.request;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {
    private String author;
    private LocalDate birthDate;
    private String nationality;
}
