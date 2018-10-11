package com.andrejeru.carshop.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Represents cars which are already sold by shop. Has a relation to {@link Car}
 *
 * an have aditional fields, for example, customer data.
 * */
@Entity
@Table(name = "Car_Sold")
public class SoldCar {
    @Id
    @GeneratedValue
    @Column(name = "cr_id")
    private Long id;

    /**
     * Information about the car itself
     * */
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "car_id", nullable = false, unique = true)
    private Car car;

    @Column(name = "ctp_sale_date")
    @Temporal(TemporalType.DATE)
    private Date saleDate;

    public SoldCar() {
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

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoldCar soldCar = (SoldCar) o;
        return Objects.equals(id, soldCar.id) &&
                Objects.equals(car, soldCar.car) &&
                Objects.equals(saleDate, soldCar.saleDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car, saleDate);
    }
}
