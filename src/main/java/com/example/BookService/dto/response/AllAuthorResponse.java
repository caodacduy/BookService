package com.example.BookService.dto.response;


import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllAuthorResponse {
    private String author;
    private LocalDate birthDate;
    private String nationality;

}
