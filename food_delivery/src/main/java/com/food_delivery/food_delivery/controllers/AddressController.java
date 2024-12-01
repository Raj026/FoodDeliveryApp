package com.food_delivery.food_delivery.controllers;

import com.food_delivery.food_delivery.models.Address;
import com.food_delivery.food_delivery.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping()
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        Address savedAddress = addressService.addAddress(address);
        return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable("id") int addressId){
        Address fetchedAddress = addressService.getAddress(addressId);
        return new ResponseEntity<>(fetchedAddress, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Address>> getAddresses(){
        List<Address> fetchedAddresses = addressService.getAddresses();
        return new ResponseEntity<>(fetchedAddresses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable("id") int addressId, @RequestBody Address address){
        return ResponseEntity.ok(addressService.updateAddress(addressId, address));
    }
}
