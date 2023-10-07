package com.wesleg.devopsproject.core.usecase.integration;

import com.wesleg.devopsproject.core.model.Car;
import com.wesleg.devopsproject.core.usecase.CarCrudUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Car Crud Use Case Integration Test")
class CarCrudUseCaseIntegrationTest {

    @Autowired
    private CarCrudUseCase crudCarUseCase;

    @Test
    @Transactional
    @DisplayName("Save Car")
    void createCar() {
        Car newCar = generateCar();

        Car createdCar = crudCarUseCase.save(newCar);

        assertNotNull(createdCar);
        assertNotNull(createdCar.getId());

        newCar.setId(createdCar.getId());
        Car savedCar = crudCarUseCase.get(createdCar.getId());

        assertEquals(newCar, savedCar);
    }

    @Test
    @Transactional
    @DisplayName("Get Cars")
    void getCars() {
        List<Car> newCars = List.of(generateCar(), generateCar(), generateCar());

        newCars.forEach(car -> crudCarUseCase.save(car));

        List<Car> carsResponse = crudCarUseCase.getList();
        assertFalse(carsResponse.isEmpty());
    }

    @Test
    @Transactional
    @DisplayName("Get Car")
    void getCar() {
        Car newCar = generateCar();
        Car createdCar = crudCarUseCase.save(newCar);

        Car carResponse = crudCarUseCase.get(createdCar.getId());

        assertNotNull(carResponse);
        assertEquals(newCar.getName(), carResponse.getName());
        assertEquals(newCar.getColor(), carResponse.getColor());
        assertEquals(newCar.getYear(), carResponse.getYear());
    }

    @Test
    @Transactional
    @DisplayName("Update Car")
    void updateCar() {
        Car newCar = generateCar();
        Car createdCar = crudCarUseCase.save(newCar);

        createdCar.setName("Updated Car");
        createdCar.setColor("Blue");
        createdCar.setYear(2021);

        Car updatedCar = crudCarUseCase.update(createdCar);

        assertNotNull(updatedCar);
        assertEquals(createdCar, updatedCar);
    }

    @Test
    @Transactional
    @DisplayName("Delete Car")
    void deleteCar() {
        Car newCar = generateCar();
        Car createdCar = crudCarUseCase.save(newCar);

        crudCarUseCase.delete(createdCar.getId());

        assertThrows(RuntimeException.class, () -> crudCarUseCase.get(createdCar.getId()));
    }

    private Car generateCar() {
        Car car = new Car();
        car.setName("New Car");
        car.setColor("Red");
        car.setYear(2023);
        return car;
    }
}
