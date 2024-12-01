package com.food_delivery.food_delivery.services;


import com.food_delivery.food_delivery.models.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant getRestaurant(int restaurantId);
    List<Restaurant> getRestaurants();

    Restaurant updateRestaurant(int restaurantId, Restaurant restaurant);
}
