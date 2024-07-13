package com.libraryapp.persistence;


import com.libraryapp.entity.CategoryEntity;

import java.util.List;
import java.util.Optional;

public interface ICategoryDAO {

    List<CategoryEntity> findAll();

    Optional<CategoryEntity> findById(Long id);

    void save(CategoryEntity category);

    void deleteById(Long id);

}
