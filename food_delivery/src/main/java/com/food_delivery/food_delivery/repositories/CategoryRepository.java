package com.food_delivery.food_delivery.repositories;

import com.food_delivery.food_delivery.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findFirstByCategoryName(String categoryName);
}
