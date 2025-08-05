package com.example.BookService.dto.request;



import com.example.BookService.enumType.ERole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    @NotEmpty(message = "NOT_NULL")
    @Email(message = "EMAIL_FORMAT")
    private String email;

    @NotEmpty(message = "NOT_NULL")
    private String username;

    @NotEmpty(message = "NOT_NULL")
    @Size(min = 8, message = "INVALID_PASSWORD")
    private String password;
    private ERole role;
}
