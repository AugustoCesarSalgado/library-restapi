package com.libraryapp.controller;

import com.libraryapp.controller.dto.LoanDTO;
import com.libraryapp.entity.BookEntity;
import com.libraryapp.entity.LoanEntity;
import com.libraryapp.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library/loan")
public class LoanController {

    @Autowired
    private ILoanService loanService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<LoanDTO> loanList = loanService.findAll()
                .stream()
                .map(loan -> LoanDTO.builder()
                        .id(loan.getId())
                        .loanDate(loan.getLoanDate())
                        .returnDate(loan.getReturnDate())
                        .book(loan.getBook())
                        .user(loan.getUser())
                        .build())
                .toList();

        return new ResponseEntity<>(loanList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<LoanEntity> loanOptional = loanService.findById(id);

        if (loanOptional.isPresent()) {
            LoanEntity loan = loanOptional.get();

            LoanDTO loanDTO = LoanDTO.builder()
                    .id(loan.getId())
                    .loanDate(loan.getLoanDate())
                    .returnDate(loan.getLoanDate())
                    .book(loan.getBook())
                    .user(loan.getUser())
                    .build();
            return new ResponseEntity<>(loanDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
