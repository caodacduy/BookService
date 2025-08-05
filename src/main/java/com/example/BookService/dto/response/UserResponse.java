package com.example.BookService.dto.response;


import com.example.BookService.enumType.ERole;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private int id;
    private String email;
    private String username;
    private String password;
    private ERole role;
}
