package com.andrejeru.carshop.controllers;

import com.andrejeru.carshop.model.CarToPurchase;
import com.andrejeru.carshop.model.InventoryItem;
import com.andrejeru.carshop.services.InventoryItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Rest controller for all cars which are purchased and in inventory.
 * The base url is "/api/inventory-items".
 * */
@RestController
@RequestMapping("/api/inventory-items")
public class InventoryItemsController {
    @Autowired
    InventoryItemsService inventoryItemsService;

    /**
     * Gets all cars for purchase. Method is Get
     *
     * @return Gets all cars for purchase
     * */
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<InventoryItem> getAllInventoryItems() {
        return inventoryItemsService.getAllInventoryitems();
    }

    /**
     * Removes car by id from cars from purchase list and adds it to inventory list.
     *
     * @param car which car to buy
     * */
    @RequestMapping( method = RequestMethod.POST)
    public void buyCar(@RequestBody CarToPurchase car) {
        inventoryItemsService.buyCar(car.getId());
    }

    /**
     * Gets all cars from inventory, filtering them by specified parameters.
     *
     * @param reserved get only cars which are reserved.
     *                 if true than receive only reserved cards. If false - all.
     * @param minPrice get cars which price is higher than specified.
     * @param maxPrice get cars which price is lower than specified.
     *
     * @return all cars from inventory, filtering them by specified parameters.
     * */
    @RequestMapping(
            method = RequestMethod.GET,
            params = {
                    "only-reserved",
                    "min-price",
                    "max-price"
            }
    )
    public Iterable<InventoryItem> getAllInventoryItems(
            @RequestParam("only-reserved") Boolean reserved,
            @RequestParam("min-price") Integer minPrice,
            @RequestParam("max-price") Integer maxPrice
    ) {

        return inventoryItemsService.getAllInventoryitems(reserved, minPrice, maxPrice);
    }
}
