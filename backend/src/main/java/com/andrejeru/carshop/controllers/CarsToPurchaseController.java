package com.andrejeru.carshop.controllers;

import com.andrejeru.carshop.model.CarToPurchase;
import com.andrejeru.carshop.services.CarsToPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * Rest controllers for all cars for purchase. The base url is "/api/cars-to-purchase".
 * */
@RestController
@RequestMapping("/api/cars-to-purchase")
public class CarsToPurchaseController {

    @Autowired
    private CarsToPurchaseService carsToPurchaseService;

    /**
     * Gets simply all cars for purchase. Method is Get
     *
     * @return all cars for purchase
     * */
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<CarToPurchase> getAllCarsToPurchase() {
        return carsToPurchaseService.getAllCarsToPurchase();
    }

    /**
     * Gets all cars for purchase, which brand starts with specified string. Method is Get
     *
     * @param brandBeginsWith brand name must begin with this string
     *
     * @return all cars for purchase, which brand starts with specified string
     * */
    @RequestMapping(
            method = RequestMethod.GET,
            params = {"brand-begins-with"}
    )
    public Iterable<CarToPurchase> getAllCarsToPurchaseByBrand(
            @RequestParam("brand-begins-with") String brandBeginsWith
    ) {
        System.out.println("Begins with : " + brandBeginsWith);

        return carsToPurchaseService.getAllCarsToPurchaseByBrand(brandBeginsWith);
    }

}
