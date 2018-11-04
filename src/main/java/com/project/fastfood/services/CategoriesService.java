package com.project.fastfood.services;

import com.project.fastfood.entities.CategoriesEntity;
import com.project.fastfood.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {
    @Autowired
    CategoriesRepository categoriesRepository;

    public List<CategoriesEntity> findAllCategories() {
        return categoriesRepository.findAll();
    }

    public void saveCategory(CategoriesEntity category) {
        categoriesRepository.save(category);
    }
}
