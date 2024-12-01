package com.food_delivery.food_delivery.services;

import com.food_delivery.food_delivery.models.Category;
import com.food_delivery.food_delivery.models.Items;
import com.food_delivery.food_delivery.models.Menu;
import com.food_delivery.food_delivery.models.Restaurant;
import com.food_delivery.food_delivery.repositories.CategoryRepository;
import com.food_delivery.food_delivery.repositories.MenuRepository;
import com.food_delivery.food_delivery.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Menu getMenuByRestaurant(int restaurantId) {
        Restaurant fetchedRestaurant = restaurantRepository.findById(restaurantId).orElse(null);
        if(fetchedRestaurant.getMenu() == null){
            System.out.println("Restaurant returning null");
            return fetchedRestaurant.getMenu();
        }

        return fetchedRestaurant.getMenu();
    }

    @Override
    public Menu addMenu(int restaurantId,Menu menu) {
        Restaurant fetchedRestaurant = restaurantRepository.findById(restaurantId).orElse(null);
        if(fetchedRestaurant.getMenu() == null){
            for(Items items: menu.getItems()){
                Category category =items.getCategory();
                if(category != null && category.getCategoryName()!=null){
//                    Category existingCategory = categoryRepository.findByCategoryName(category.getCategoryName()).orElse(null);
//                    items.setCategory(existingCategory);
                    Category categories = categoryRepository.findFirstByCategoryName(category.getCategoryName()).orElse(null);
                    items.setCategory(categories);
                }
            }
            menu.setRestaurant(fetchedRestaurant);
            fetchedRestaurant.setMenu(menu);
            Restaurant savedRestaurant = restaurantRepository.save(fetchedRestaurant);
            return savedRestaurant.getMenu();
        }


        return fetchedRestaurant.getMenu();
    }


//    @Override
//    public Menu addMenu(Menu menu) {
//        return menuRepository.save(menu);
//    }
//
//    @Override
//    public Menu getMenu(int menuId) {
//        return menuRepository.findById(menuId).orElse(null);
//    }
//
//    @Override
//    public List<Menu> getMenus() {
//        return menuRepository.findAll();
//    }


}
