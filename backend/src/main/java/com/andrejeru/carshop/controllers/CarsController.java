package com.andrejeru.carshop.controllers;

import com.andrejeru.carshop.model.Car;
import com.andrejeru.carshop.services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 * Rest controller for all cars manipulation. The base url is "/api/cars". Controller
 * contains method which are mapped to GET and gets info about the cars.
 *
 * Cars have three possible state:
 *
 * 1) Is unpurchased
 * 2) Is in the shop inventory
 * 3) Is sold
 *
 * This controller is for every car in the system.
 *
 * */
@RestController()
@RequestMapping(path = "/api/cars")
public class CarsController {

    @Autowired
    private CarsService carsService;

    /**
     * Receives all cars in a system.
     *
     * @return all cars in a system
     * */
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Car> getAllCars() {
        return carsService.getAllCars();
    }
}
