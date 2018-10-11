package com.andrejeru.carshop.controllers;

import com.andrejeru.carshop.model.InventoryItem;
import com.andrejeru.carshop.model.SoldCar;
import com.andrejeru.carshop.services.InventoryItemsService;
import com.andrejeru.carshop.services.SoldCarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/sold-cars")
public class SoldCarsController {

    @Autowired
    SoldCarsService soldCarsService;

    @Autowired
    InventoryItemsService inventoryItemsService;

    /**
     * Gets all sold cars for purchase. Method is Get
     *
     * @return Gets all cars for purchase
     * */
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<SoldCar> getAllSoldCars() {
        return soldCarsService.getAllSoldCars();
    }

    /**
     * Removes car by id from cars from inventory list and adds it to sold cars list.
     *
     * @param car which car to buy
     * */
    @RequestMapping(method = RequestMethod.POST)
    public void sellCar(@RequestBody InventoryItem car) {
        inventoryItemsService.sellCar(car.getId());
    }
}
