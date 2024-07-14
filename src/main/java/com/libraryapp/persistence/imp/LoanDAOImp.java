package com.libraryapp.persistence.imp;

import com.libraryapp.entity.BookEntity;
import com.libraryapp.entity.LoanEntity;
import com.libraryapp.persistence.ILoanDAO;
import com.libraryapp.repository.LoanRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LoanDAOImp implements ILoanDAO {

    private LoanRepository loanRepository;

    @Override
    public List<LoanEntity> findAll() {
        return (List<LoanEntity>) loanRepository.findAll();
    }

    @Override
    public Optional<LoanEntity> findById(Long id) {
        return loanRepository.findById(id);
    }

    @Override
    public Optional<LoanEntity> findByBook(BookEntity book) {
        return loanRepository.findLoanEntityByBook(book);
    }

    @Override
    public void save(LoanEntity loan) {
        loanRepository.save(loan);
    }

    @Override
    public void deleteById(Long id) {
        loanRepository.deleteById(id);
    }
}
