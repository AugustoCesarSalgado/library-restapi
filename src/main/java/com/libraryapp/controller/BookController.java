package com.libraryapp.controller;

import com.libraryapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/book")
public class BookController {

    @Autowired
    private IBookService bookService;

}
