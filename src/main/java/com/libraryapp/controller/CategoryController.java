package com.libraryapp.controller;

import com.libraryapp.controller.dto.CategoryDTO;
import com.libraryapp.entity.CategoryEntity;
import com.libraryapp.service.ICategoryService;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CategoryDTO categoryDTO) throws URISyntaxException {
        if (categoryDTO.getName().isBlank()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        categoryService.save(CategoryEntity.builder()
                .name(categoryDTO.getName())
                .build());

        return new ResponseEntity<>(new URI("/library/category/save"), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {

        Optional<CategoryEntity> categoryOptional = categoryService.findById(id);

        if (categoryOptional.isPresent()) {
            CategoryEntity category = categoryOptional.get();
            category.setName(categoryDTO.getName());
            categoryService.save(category);
            return new ResponseEntity<>("Category updated", HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (id != null) {
            categoryService.deleteById(id);
            return new ResponseEntity<>("Category deleted", HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
