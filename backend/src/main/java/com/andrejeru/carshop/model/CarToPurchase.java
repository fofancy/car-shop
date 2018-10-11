package com.andrejeru.carshop.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Represents cars which could be purchased. Has a relation to {@link Car}
 *
 * Can have additional fields.
 * */
@Entity
@Table(name = "Car_To_Purchase")
public class CarToPurchase {
    @Id
    @GeneratedValue
    @Column(name = "ctp_id")
    private Long id;

    /**
     * Information about the car itself
     * */
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "car_id", nullable = false, unique = true)
    private Car car;

    public CarToPurchase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarToPurchase carToPurchase = (CarToPurchase) o;
        return Objects.equals(id, carToPurchase.id) &&
                Objects.equals(car, carToPurchase.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car);
    }

}
