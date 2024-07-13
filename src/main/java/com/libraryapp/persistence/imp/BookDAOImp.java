package com.libraryapp.persistence.imp;

import com.libraryapp.entity.BookEntity;
import com.libraryapp.persistence.IBookDAO;
import com.libraryapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAOImp implements IBookDAO {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookEntity> findAll() {
        return (List<BookEntity>) bookRepository.findAll();
    }

    @Override
    public Optional<BookEntity> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(BookEntity book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
