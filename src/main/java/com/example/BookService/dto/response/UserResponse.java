package com.example.BookService.dto.response;


import com.example.BookService.entity.Role;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Set<Role> roles;
}
