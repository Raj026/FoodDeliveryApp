package com.food_delivery.food_delivery.services;

import com.food_delivery.food_delivery.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category addCategory(Category category);
    Category getCategory(int categoryId);
    List<Category> getCategories();

    Category updateCategory(int categoryId, Category category);

    Optional<Category> findFirstByCategoryName(String categoryName);
}
