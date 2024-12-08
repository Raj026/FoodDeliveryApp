package com.food_delivery.food_delivery.controllers;

import com.food_delivery.food_delivery.DTOs.LoginResponse;
import com.food_delivery.food_delivery.DTOs.LoginUserDto;
import com.food_delivery.food_delivery.DTOs.RegisterUserDto;
import com.food_delivery.food_delivery.models.User;
import com.food_delivery.food_delivery.services.AuthenticationService;
import com.food_delivery.food_delivery.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;


    public AuthenticationController(AuthenticationService authenticationService, JwtService jwtService) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signUp(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenitcatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenitcatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
