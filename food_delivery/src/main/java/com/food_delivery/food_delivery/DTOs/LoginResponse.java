package com.food_delivery.food_delivery.DTOs;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private long expiresIn;

}