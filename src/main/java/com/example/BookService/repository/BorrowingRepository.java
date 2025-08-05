package com.example.BookService.repository;


import com.example.BookService.entity.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing,Integer> {
    Optional<Borrowing> findTopByBookIdOrderByBorrowDateDesc(int bookId);

    Optional<Borrowing> findById(int id);

    List<Borrowing> findAllByUser_Id(int userId);

}
