package com.andrejeru.carshop.services;

import com.andrejeru.carshop.data.CarsRepository;
import com.andrejeru.carshop.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for all cars manipulation
 * */
@Service
public class CarsService {
    @Autowired
    CarsRepository carsRepository;

    public Iterable<Car> getAllCars() {
        return carsRepository.findAll();
    }
}
