package com.food_delivery.food_delivery.services;

import com.food_delivery.food_delivery.models.Category;
import com.food_delivery.food_delivery.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategory(int categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(int categoryId, Category category) {
        Category fetchedCategory = categoryRepository.findById(categoryId).orElse(null);
        if(fetchedCategory != null){
            fetchedCategory.setCategoryName(category.getCategoryName());
        }
        return fetchedCategory;
    }


    @Override
    public Optional<Category> findFirstByCategoryName(String categoryName) {
        return categoryRepository.findFirstByCategoryName(categoryName);
    }
}
