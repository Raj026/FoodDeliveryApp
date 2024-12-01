package com.food_delivery.food_delivery.controllers;

import com.food_delivery.food_delivery.models.Menu;
import com.food_delivery.food_delivery.services.MenuService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurant")
public class MenuController {

    @Autowired
    private MenuService menuService;
    @GetMapping("/{restaurant_id}/menu")
    public ResponseEntity<Menu> getMenuByRestaurant(@PathVariable("restaurant_id") int restaurantId){
        return new ResponseEntity<>(menuService.getMenuByRestaurant(restaurantId), HttpStatus.OK);
    }

    @PostMapping("/{restaurant_id}/menu")
    public ResponseEntity<Menu> addMenu(@PathVariable("restaurant_id") int restaurantId,@RequestBody Menu menu){
        return new ResponseEntity<>(menuService.addMenu(restaurantId, menu), HttpStatus.CREATED);
    }
}
