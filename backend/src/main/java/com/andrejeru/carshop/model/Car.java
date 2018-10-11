package com.andrejeru.carshop.model;


import javax.persistence.*;
import java.util.Objects;

/**
 * Represents all cars and all their attributes.
 *
 * Separate cars lists by additional entity is a better solution, because they
 * can pe extended and have additional data.
 *
 * Also it could beimplemented having a simple flag or field which would define,
 * whether this car is purchased or sold, but permoed here solution is more flexible
 * */
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue
    @Column(name = "car_id")
    private Long id;

    @Column(name = "car_brand")
    private String brand;

    @Column(name = "car_color")
    private String color;

    @Column(name = "car_vihecle_id")
    private String vin;

    @Column(name = "car_price")
    private Integer price;

    @Column(name = "car_reserved")
    private Boolean reserved;

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(color, car.color) &&
                Objects.equals(vin, car.vin) &&
                Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, color, vin, price);
    }
}
