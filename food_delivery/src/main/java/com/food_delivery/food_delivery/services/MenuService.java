package com.food_delivery.food_delivery.services;

import com.food_delivery.food_delivery.models.Menu;

import java.util.List;

public interface MenuService {
//    Menu addMenu(Menu menu);
//    Menu getMenu(int menuId);
//    List<Menu> getMenus();

    Menu getMenuByRestaurant(int restaurantId);
    Menu addMenu(int restaurantId, Menu menu);

}
