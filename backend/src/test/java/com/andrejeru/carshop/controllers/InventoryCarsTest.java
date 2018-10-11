package com.andrejeru.carshop.controllers;

import com.andrejeru.carshop.model.CarToPurchase;
import com.andrejeru.carshop.model.InventoryItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InventoryCarsTest {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Tests whethher the cars purchased and sold right
     * */
    @Test
    public void getAllCars() {
        // Initial size is 6
        ResponseEntity<Iterable> response = this.restTemplate.getForEntity(
                "http://localhost:" + port + "/api/cars-to-purchase",
                Iterable.class
        );
        List cars = (List) response.getBody();
        assertThat(cars.size()).isEqualTo(6);

        // Buy one car
        HttpHeaders headers = new HttpHeaders();
        CarToPurchase carToPurchase = new CarToPurchase();
        carToPurchase.setId(1L);
        HttpEntity<CarToPurchase> carToPurchaseHttpEntity = new HttpEntity<>(carToPurchase, headers);
        ResponseEntity<InventoryItem> responseEntity =
                this.restTemplate.postForEntity(
                        "http://localhost:" + port + "/api/inventory-items", carToPurchaseHttpEntity, InventoryItem.class);

        // Size must become 5
        response = this.restTemplate.getForEntity(
                "http://localhost:" + port + "/api/cars-to-purchase",
                Iterable.class
        );
        cars = (List) response.getBody();
        assertThat(cars.size()).isEqualTo(5);

        // And size of a list of cars in inventory must become 1
        response = this.restTemplate.getForEntity(
                "http://localhost:" + port + "/api/inventory-items",
                Iterable.class
        );
        cars = (List) response.getBody();
        assertThat(cars.size()).isEqualTo(1);

        // Sell this car
        InventoryItem item = new InventoryItem();
        carToPurchase.setId(responseEntity.getBody().getId());
        HttpEntity<InventoryItem> itemEntity = new HttpEntity<>(item, headers);
        this.restTemplate.postForEntity(
                "http://localhost:" + port + "/api/sold-cars", carToPurchaseHttpEntity, String.class
        );

        // Size of inventory list must be 0
        response = this.restTemplate.getForEntity(
                "http://localhost:" + port + "/api/inventory-items",
                Iterable.class
        );
        cars = (List) response.getBody();
        assertThat(cars.size()).isEqualTo(0);

        // Size of sold cars must be 1
        response = this.restTemplate.getForEntity(
                "http://localhost:" + port + "/api/sold-cars",
                Iterable.class
        );
        cars = (List) response.getBody();
        assertThat(cars.size()).isEqualTo(1);

    }
}
