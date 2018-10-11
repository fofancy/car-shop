package com.andrejeru.carshop.services;

import com.andrejeru.carshop.data.CarsToPurchaseRepository;
import com.andrejeru.carshop.data.InventoryItemsRepository;
import com.andrejeru.carshop.data.SoldCarsRepository;
import com.andrejeru.carshop.model.CarToPurchase;
import com.andrejeru.carshop.model.InventoryItem;
import com.andrejeru.carshop.model.SoldCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Service for all cars which are already in inventory
 * */
@Service
public class InventoryItemsService {
    @Autowired
    private InventoryItemsRepository inventoryItemsRepository;
    @Autowired
    private SoldCarsRepository soldCarsRepository;
    @Autowired
    private CarsToPurchaseRepository carsToPurchaseRepository;

    public Iterable<InventoryItem> getAllInventoryitems() {
        return inventoryItemsRepository.findAll();
    }

    /**
     * Get car data by its id from inventory list, constructs new object which represents sold car
     * with additional field "sale date" and puts it in sold items list
     *  @param inventoryItemId car's to sell id
     * */
    public SoldCar sellCar(Long inventoryItemId) {
        Optional<InventoryItem> inventoryItem = inventoryItemsRepository.findById(inventoryItemId);

        if(!inventoryItem.isPresent()) {
            throw new NoSuchElementException();
        }

        SoldCar soldCar = new SoldCar();
        soldCar.setCar(inventoryItem.get().getCar());
        soldCar.setSaleDate(new Date(Calendar.getInstance().getTime().getTime()));

        inventoryItemsRepository.deleteById(inventoryItemId);
        return soldCarsRepository.save(soldCar);
    }

    /**
     * Get car data by its id from unpurchased cars list, constructs new object which represents purchased car
     * with additional field "purchase date" and puts it in sold items list
     *  @param carToBuyId car's to buy id
     * */
    public InventoryItem buyCar(Long carToBuyId) {
        Optional<CarToPurchase> inventoryItem = carsToPurchaseRepository.findById(carToBuyId);

        if(!inventoryItem.isPresent()) {
            throw new NoSuchElementException();
        }

        InventoryItem item = new InventoryItem();
        item.setCar(inventoryItem.get().getCar());
        item.setPurchaseDate(new Date(Calendar.getInstance().getTime().getTime()));

        carsToPurchaseRepository.deleteById(carToBuyId);
        return inventoryItemsRepository.save(item);
    }



    /**
     * Gets all cars from inventory lists.
     *
     * @param reserved if true than receive only reserved cards. If false - all.
     * @param minPrice min Price of a car
     * @param maxPrice maxPrice of a car
     * */
    public Iterable<InventoryItem> getAllInventoryitems(Boolean reserved, Integer minPrice, Integer maxPrice) {
        if(reserved) {
            return inventoryItemsRepository.getAllByCarReservedAndCar_PriceBetween(reserved, minPrice, maxPrice);
        }
        else {
            return inventoryItemsRepository.getAllByCar_PriceBetween(minPrice, maxPrice);
        }
    }
}
