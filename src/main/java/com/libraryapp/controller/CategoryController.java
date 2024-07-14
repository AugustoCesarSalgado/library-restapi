package com.libraryapp.controller;

import com.libraryapp.controller.dto.CategoryDTO;
import com.libraryapp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<CategoryDTO> categoryList = categoryService.findAll()
                .stream()
                .map(category -> CategoryDTO.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .books(category.getBooks())
                        .build())
                .toList();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

}
