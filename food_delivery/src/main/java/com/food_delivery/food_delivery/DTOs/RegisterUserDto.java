package com.food_delivery.food_delivery.DTOs;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String email;
    private String password;
    private String fullName;

}
