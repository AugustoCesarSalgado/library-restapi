package com.libraryapp.controller;

import com.libraryapp.controller.dto.LoanDTO;
import com.libraryapp.entity.LoanEntity;
import com.libraryapp.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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
                    .returnDate(loan.getReturnDate())
                    .book(loan.getBook())
                    .user(loan.getUser())
                    .build();
            return new ResponseEntity<>(loanDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody LoanDTO loanDTO) throws URISyntaxException {
        if (loanDTO.getLoanDate() == null || loanDTO.getReturnDate() == null || loanDTO.getBook() == null || loanDTO.getUser() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        LoanEntity loan = LoanEntity.builder()
                .loanDate(loanDTO.getLoanDate())
                .returnDate(loanDTO.getLoanDate())
                .book(loanDTO.getBook())
                .user(loanDTO.getUser())
                .build();

        loanService.save(loan);

        return new ResponseEntity<>(new URI("/library/loan/save"), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody LoanDTO loanDTO) {
        Optional<LoanEntity> loanOptional = loanService.findById(id);

        if (loanOptional.isPresent()) {
            LoanEntity loan = loanOptional.get();
            loan.setReturnDate(loanDTO.getReturnDate());
            loanService.save(loan);

            return new ResponseEntity<>("Loan updated", HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (id != null) {
            loanService.deleteById(id);
            return new ResponseEntity<>("Loan deleted", HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
