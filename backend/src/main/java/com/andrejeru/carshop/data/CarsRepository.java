package com.andrejeru.carshop.data;

import com.andrejeru.carshop.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for all cars manipulation
 * */
@Repository
public interface CarsRepository extends CrudRepository<Car, Long> {

}
