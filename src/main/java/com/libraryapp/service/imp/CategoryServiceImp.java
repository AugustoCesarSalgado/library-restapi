package com.libraryapp.service.imp;

import com.libraryapp.entity.CategoryEntity;
import com.libraryapp.persistence.ICategoryDAO;
import com.libraryapp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements ICategoryService {

    @Autowired
    private ICategoryDAO categoryDAO;

    @Override
    public List<CategoryEntity> findAll() {
        return (List<CategoryEntity>) categoryDAO.findAll();
    }

    @Override
    public Optional<CategoryEntity> findById(Long id) {
        return categoryDAO.findById(id);
    }

    @Override
    public void save(CategoryEntity category) {
        categoryDAO.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryDAO.deleteById(id);
    }
}
