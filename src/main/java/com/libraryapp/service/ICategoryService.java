package com.libraryapp.service;

import com.libraryapp.entity.CategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ICategoryService {

    List<CategoryEntity> findAll();

    Optional<CategoryEntity> findById(Long id);

    void save(CategoryEntity category);

    void deleteById(Long id);

}
