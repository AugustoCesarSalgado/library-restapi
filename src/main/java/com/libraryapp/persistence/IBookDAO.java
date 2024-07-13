package com.libraryapp.persistence;

import com.libraryapp.entity.BookEntity;
import com.libraryapp.entity.CategoryEntity;

import java.util.List;
import java.util.Optional;

public interface IBookDAO {

    List<BookEntity> findAll();

    Optional<BookEntity> findById(Long id);

    void save(BookEntity book);

    void deleteById(Long id);

}
