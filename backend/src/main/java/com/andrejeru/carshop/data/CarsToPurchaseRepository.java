package com.andrejeru.carshop.data;

import com.andrejeru.carshop.model.CarToPurchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Repository for cars for purchase manipulation
 * */
@Repository
public interface CarsToPurchaseRepository extends CrudRepository<CarToPurchase, Long> {

    /**
     * Gets all cars which brand starts with
     * */
    @Query("Select c from CarToPurchase c where c.car.brand like :brand%")
    Iterable<CarToPurchase> findByCarBrandLike(@Param("brand") String brand);
}
