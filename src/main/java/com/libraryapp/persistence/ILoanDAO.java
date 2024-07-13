package com.libraryapp.persistence;

import com.libraryapp.entity.BookEntity;
import com.libraryapp.entity.LoanEntity;

import java.util.List;
import java.util.Optional;

public interface ILoanDAO {

    List<LoanEntity> findAll();

    Optional<LoanEntity> findById(Long id);

    Optional<LoanEntity> findByBook(BookEntity book);

    void save(LoanEntity loan);

    void deleteById(Long id);

}
