package com.food_delivery.food_delivery.services;

import com.food_delivery.food_delivery.models.Address;

import java.util.List;

public interface AddressService {
    Address addAddress(Address address);
    Address getAddress(int addressId);
    List<Address> getAddresses();

    Address updateAddress(int addressId, Address address);

}
