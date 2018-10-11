package com.andrejeru.carshop.services;

import com.andrejeru.carshop.data.CarsToPurchaseRepository;
import com.andrejeru.carshop.model.CarToPurchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for all unpurchased cars
 * */
@Service
public class CarsToPurchaseService {
    @Autowired
    CarsToPurchaseRepository carsToPurchaseRepository;

    public Iterable<CarToPurchase> getAllCarsToPurchase() {
        return carsToPurchaseRepository.findAll();
    }

    public Iterable<CarToPurchase> getAllCarsToPurchaseByBrand(String brandBeginsWith) {
        return carsToPurchaseRepository.findByCarBrandLike(brandBeginsWith);

    }
}
