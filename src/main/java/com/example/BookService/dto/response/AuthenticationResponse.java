package com.example.BookService.dto.response;

import com.example.BookService.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationResponse {
    String token;
    private int id;
    private String email;
    private String username;
    private Set<Role> roles;
}
