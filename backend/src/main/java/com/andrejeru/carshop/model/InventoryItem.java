package com.andrejeru.carshop.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


/**
 * Represents cars which are already be purchased by shop. Has a relation to {@link Car}
 *
 * Can have aditional fields nad relations for example to shop and inventory.
 * */
@Entity
@Table(name = "Inventory_Item")
public class InventoryItem {
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

    @Column(name = "ctp_pur_date")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

    public InventoryItem() {
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

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryItem that = (InventoryItem) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(car, that.car) &&
                Objects.equals(purchaseDate, that.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car, purchaseDate);
    }
}
