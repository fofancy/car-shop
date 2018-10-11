package com.andrejeru.carshop.services;

import com.andrejeru.carshop.data.SoldCarsRepository;
import com.andrejeru.carshop.model.SoldCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Service for all cars which are sold
 * */
@Service
public class SoldCarsService {
    @Autowired
    private SoldCarsRepository soldCarsRepository;

    public Iterable<SoldCar> getAllSoldCars() {
        return soldCarsRepository.findAll();
    }
}
