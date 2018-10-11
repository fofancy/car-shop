package com.andrejeru.carshop.data;

import com.andrejeru.carshop.model.InventoryItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for all cars which are in inventory
 * */
@Repository
public interface InventoryItemsRepository extends CrudRepository<InventoryItem, Long> {
    Iterable<InventoryItem> getAllByCar_Brand(String brand);
    Iterable<InventoryItem> getAllByCarReserved(Boolean reserved);
    Iterable<InventoryItem> getAllByCarReservedAndCar_PriceBetween(
            Boolean reserved, Integer lowerValue, Integer upperValue );

    Iterable<InventoryItem> getAllByCar_PriceBetween(Integer minPrice, Integer maxPrice);
}
