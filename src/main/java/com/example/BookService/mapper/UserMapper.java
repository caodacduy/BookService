package com.example.BookService.mapper;

import com.example.BookService.dto.request.UserRequest;
import com.example.BookService.dto.response.UserResponse;
import com.example.BookService.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequest request);
    UserResponse toUserResponse(User user);
}
