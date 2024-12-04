package com.food_delivery.food_delivery.controllers;

import com.food_delivery.food_delivery.models.Restaurant;
import com.food_delivery.food_delivery.services.RestaurantService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping()
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant){
        return new ResponseEntity<>(restaurantService.addRestaurant(restaurant), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
//    @Cacheable(value = "restaurant", key = "#restaurantId")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable("id") int restaurantId){
        return new ResponseEntity<Restaurant>(restaurantService.getRestaurant(restaurantId), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Restaurant>> getRestaurants(){
        return new ResponseEntity<>(restaurantService.getRestaurants(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable("id") int restaurantId, Restaurant restaurant){
        return new ResponseEntity<>(restaurantService.updateRestaurant(restaurantId, restaurant), HttpStatus.OK);
    }

}
