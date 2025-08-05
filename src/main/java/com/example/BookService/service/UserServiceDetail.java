//package com.example.BookService.service;
//
//import com.example.BookService.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class UserServiceDetail {
//    private final UserRepository userRepository;
//
//    public UserDetailsService UserServiceDetail (){
//        return email -> userRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
//    }
//}
