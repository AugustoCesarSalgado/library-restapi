package com.libraryapp.controller;

import com.libraryapp.controller.dto.BookDTO;
import com.libraryapp.entity.BookEntity;
import com.libraryapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<BookDTO> bookList = bookService.findAll()
                .stream()
                .map(book -> BookDTO.builder()
                        .id(book.getId())
                        .title(book.getTitle())
                        .author(book.getAuthor())
                        .year(book.getYear())
                        .category(book.getCategory())
                        .build())
                .toList();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<BookEntity> bookOptional = bookService.findById(id);

        if (bookOptional.isPresent()) {
            BookEntity book = bookOptional.get();

            BookDTO bookDTO = BookDTO.builder()
                    .id(book.getId())
                    .title(book.getTitle())
                    .author(book.getAuthor())
                    .year(book.getYear())
                    .category(book.getCategory())
                    .build();
            return new ResponseEntity<>(bookDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody BookDTO bookDTO) throws URISyntaxException {
        if (bookDTO.getTitle().isBlank()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        BookEntity book = BookEntity.builder()
                .title(bookDTO.getTitle())
                .author(bookDTO.getAuthor())
                .year(bookDTO.getYear())
                .category(bookDTO.getCategory())
                .build();

        bookService.save(book);

        return new ResponseEntity<>(new URI("/library/book/save"), HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        Optional<BookEntity> bookOptional = bookService.findById(id);

        if (bookOptional.isPresent()) {
            BookEntity book = bookOptional.get();
            book.setTitle(bookDTO.getTitle());
            book.setAuthor(bookDTO.getAuthor());
            book.setYear(bookDTO.getYear());
            book.setCategory(bookDTO.getCategory());
            bookService.save(book);

            return new ResponseEntity<>("Book updated", HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
