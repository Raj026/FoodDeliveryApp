package com.food_delivery.food_delivery.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter //these are set so as to handle bi-directional mapping and Remove toString method
// so we removed Data annotation from here
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int menuId;

    @OneToOne()
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonBackReference
    private Restaurant restaurant;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu", orphanRemoval = true)
    @JsonManagedReference
    private List<Items> items;
}
