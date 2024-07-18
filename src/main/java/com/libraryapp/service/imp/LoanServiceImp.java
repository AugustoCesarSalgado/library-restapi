package com.libraryapp.service.imp;

import com.libraryapp.entity.BookEntity;
import com.libraryapp.entity.LoanEntity;
import com.libraryapp.persistence.ILoanDAO;
import com.libraryapp.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImp implements ILoanService {

    @Autowired
    private ILoanDAO loanDAO;

    @Override
    public List<LoanEntity> findAll() {
        return (List<LoanEntity>) loanDAO.findAll();
    }

    @Override
    public Optional<LoanEntity> findById(Long id) {
        return loanDAO.findById(id);
    }

    @Override
    public Optional<LoanEntity> findByBook(BookEntity book) {
        return loanDAO.findByBook(book);
    }

    @Override
    public void save(LoanEntity loan) {
        loanDAO.save(loan);
    }

    @Override
    public void deleteById(Long id) {
        loanDAO.deleteById(id);
    }
}
