package com.example.BookService.dto.response;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponse {
    private String author;
    private LocalDate birthDate;
    private String nationality;

    private List<BookResponse> books =new ArrayList<>();
}
