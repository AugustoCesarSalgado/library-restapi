package com.libraryapp.controller.dto;

import com.libraryapp.entity.BookEntity;
import com.libraryapp.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanDTO {

    private Long id;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private BookEntity book;
    private UserEntity user;

}
