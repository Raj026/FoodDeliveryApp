package com.food_delivery.food_delivery.services;

import com.food_delivery.food_delivery.models.Address;
import com.food_delivery.food_delivery.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddress(int addressId) {
        return addressRepository.findById(addressId).orElse(null);
    }

    @Override
    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address updateAddress(int addressId, Address address) {
        Address fetchedAddress = addressRepository.findById(addressId).orElse(null);
        if(fetchedAddress!=null){
            fetchedAddress.setArea(address.getArea());
            fetchedAddress.setCity(address.getCity());
            fetchedAddress.setState(address.getState());
            fetchedAddress.setPincode(address.getPincode());
        }

        return addressRepository.save(fetchedAddress);
    }
}
