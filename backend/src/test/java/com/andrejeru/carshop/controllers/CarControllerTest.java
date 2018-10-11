package com.andrejeru.carshop.controllers;

import com.andrejeru.carshop.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllCars() {
        ResponseEntity<Iterable> response = this.restTemplate.getForEntity(
                "http://localhost:" + port + "/api/cars",
                Iterable.class
        );

        List cars = (List) response.getBody();

        assertThat(cars.size()).isEqualTo(6);
    }

}
