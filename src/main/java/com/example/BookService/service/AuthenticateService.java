package com.example.BookService.service;

import com.example.BookService.dto.request.AuthenticationRequest;

import com.example.BookService.dto.request.IntrospectRequest;
import com.example.BookService.dto.response.AuthenticationResponse;
import com.example.BookService.dto.response.IntrospectResponse;
import com.example.BookService.entity.User;
import com.example.BookService.exception.AppException;
import com.example.BookService.exception.ErrorCode;
import com.example.BookService.repository.UserRepository;
import io.jsonwebtoken.*;


import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AccessLevel;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j(topic = "JWT-SERVICE")
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticateService {

}
