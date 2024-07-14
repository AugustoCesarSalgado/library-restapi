package com.libraryapp.controller;

import com.libraryapp.controller.dto.CategoryDTO;
import com.libraryapp.entity.CategoryEntity;
import com.libraryapp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<CategoryEntity> categoryOptional = categoryService.findById(id);

        if (categoryOptional.isPresent()) {
            CategoryEntity category = categoryOptional.get();

            CategoryDTO categoryDTO = CategoryDTO.builder()
                    .id(category.getId())
                    .name(category.getName())
                    .books(category.getBooks())
                    .build();

            return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
