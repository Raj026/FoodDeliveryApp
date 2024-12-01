package com.food_delivery.food_delivery.services;

import com.food_delivery.food_delivery.models.Items;

import java.util.List;

public interface ItemsService {
    Items addItem(Items items);
    Items getItem(int itemId);

    List<Items> getItems();


}
