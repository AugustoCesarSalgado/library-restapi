package com.libraryapp.persistence.imp;

import com.libraryapp.entity.CategoryEntity;
import com.libraryapp.persistence.ICategoryDAO;
import com.libraryapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryDAOImp implements ICategoryDAO {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> findAll() {
        return (List<CategoryEntity>) categoryRepository.findAll();
    }

    @Override
    public Optional<CategoryEntity> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(CategoryEntity category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
