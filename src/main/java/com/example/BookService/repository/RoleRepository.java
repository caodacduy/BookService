package com.example.BookService.repository;

import com.example.BookService.entity.Role;

import com.example.BookService.entity.User;
import com.example.BookService.enumType.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);

}
