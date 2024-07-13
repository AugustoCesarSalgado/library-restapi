package com.libraryapp.repository;

import com.libraryapp.entity.BookEntity;
import com.libraryapp.entity.LoanEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends CrudRepository<LoanEntity, Long> {

    Optional<LoanEntity> findLoanEntityByBook(BookEntity book);

}
