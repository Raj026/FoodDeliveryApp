package com.food_delivery.food_delivery.services;

import com.food_delivery.food_delivery.models.Category;
import com.food_delivery.food_delivery.models.Items;
import com.food_delivery.food_delivery.models.Restaurant;
import com.food_delivery.food_delivery.repositories.CategoryRepository;
import com.food_delivery.food_delivery.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RedisService redisService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        if(restaurant.getMenu() != null){
            //link menu to the restaurant
            restaurant.getMenu().setRestaurant(restaurant);

            //link items to menu
            if(restaurant.getMenu().getItems() !=null){
                for(Items items: restaurant.getMenu().getItems()){
                    items.setMenu(restaurant.getMenu());
                    Category category = items.getCategory();
                    if(category != null && category.getCategoryName()!=null){
                        Category existingCategory = categoryRepository.findFirstByCategoryName(category.getCategoryName()).orElse(null);
                        items.setCategory(existingCategory);
                    }
                }

            }

        }
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurant(int restaurantId) {
        Restaurant restaurant = redisService.get("restaurantId"+restaurantId, Restaurant.class);
        if(restaurant != null){
            return restaurant;
        }

        Restaurant fetchedRestaurant = restaurantRepository.findById(restaurantId).orElse(null);
        if(fetchedRestaurant !=null){
            redisService.set("restaurantId"+restaurantId, fetchedRestaurant, 40l);
        }
        return fetchedRestaurant;
    }

    @Override
    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant updateRestaurant(int restaurantId, Restaurant restaurant) {
        Restaurant fetchedRestaurant = restaurantRepository.findById(restaurantId).orElse(null);
        if(fetchedRestaurant != null) {
            fetchedRestaurant.setRestaurantName(restaurant.getRestaurantName());
            fetchedRestaurant.setMenu(restaurant.getMenu());
            fetchedRestaurant.setAddress(restaurant.getAddress());
            fetchedRestaurant.setContactNumber(restaurant.getContactNumber());
        }

        return fetchedRestaurant;
    }
}
