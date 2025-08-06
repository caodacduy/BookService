package com.example.BookService.repository;

import com.example.BookService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    Optional<User> findById(int id);
    Optional<User> findByUsername(String username);
}
