package com.libraryapp.service;

import com.libraryapp.entity.BookEntity;
import com.libraryapp.entity.LoanEntity;

import java.util.List;
import java.util.Optional;

public interface ILoanService {

    List<LoanEntity> findAll();

    Optional<LoanEntity> findById(Long id);

    Optional<LoanEntity> findByBook(BookEntity book);

    void save(LoanEntity loan);

    void deleteById(Long id);

}
