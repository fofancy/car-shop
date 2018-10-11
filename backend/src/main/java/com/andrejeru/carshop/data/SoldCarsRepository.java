package com.andrejeru.carshop.data;

import com.andrejeru.carshop.model.SoldCar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for all sold cars
 * */
@Repository
public interface SoldCarsRepository extends CrudRepository<SoldCar, Long> {
    List<SoldCar> findAllByCar_Brand(String brand);
}
