package com.libraryapp.service;

import com.libraryapp.entity.BookEntity;

import java.util.List;
import java.util.Optional;

public interface IBookService {

    List<BookEntity> findAll();

    Optional<BookEntity> findById(Long id);

    void save(BookEntity book);

    void deleteById(Long id);

}
