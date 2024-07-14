package com.libraryapp.service.imp;

import com.libraryapp.entity.BookEntity;
import com.libraryapp.persistence.IBookDAO;
import com.libraryapp.service.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements IBookService {

    private IBookDAO bookDAO;

    @Override
    public List<BookEntity> findAll() {
        return (List<BookEntity>) bookDAO.findAll();
    }

    @Override
    public Optional<BookEntity> findById(Long id) {
        return bookDAO.findById(id);
    }

    @Override
    public void save(BookEntity book) {
        bookDAO.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookDAO.deleteById(id);
    }
}
