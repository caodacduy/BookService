package com.example.BookService.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationRequest {
    @NotEmpty(message = "NOT_NULL")
    private String email;

    @NotEmpty(message = "NOT_NULL")
    private String password;
}
