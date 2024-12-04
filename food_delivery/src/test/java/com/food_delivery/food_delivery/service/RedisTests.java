package com.food_delivery.food_delivery.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testRed(){
        redisTemplate.opsForValue().set("restaurantId", "252");
        Object restaurantId =redisTemplate.opsForValue().get("restaurantId");
        int a = 1;
    }
}
