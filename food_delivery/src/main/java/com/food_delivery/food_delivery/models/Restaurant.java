package com.food_delivery.food_delivery.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int restaurantId;
    private String restaurantName;
    private String contactNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private Address Address;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "restaurant", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Menu menu;
}
