package com.wesleg.devopsproject.core.usecase.unit;


import com.wesleg.devopsproject.core.domain.Car;
import com.wesleg.devopsproject.core.ports.output.CarCrudOutputPort;
import com.wesleg.devopsproject.core.usecase.CarCrudUseCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("Car Crud Use Case Unit Test")
class CarCrudUseCaseUnitTest {
    private static CarCrudUseCase crudCarUseCase;

    @Mock
    private static CarCrudOutputPort carCrudOutputPort;

    @BeforeAll
    static void setUp() {
        carCrudOutputPort = mock(CarCrudOutputPort.class);
        crudCarUseCase = new CarCrudUseCase(carCrudOutputPort);
    }

    @Test
    @DisplayName("Save Car")
    void createCar() {
        Car car = generateCar();

        when(carCrudOutputPort.save(car)).thenReturn(car);

        Car savedCar = crudCarUseCase.save(car);

        assertEquals(car, savedCar);
        verify(carCrudOutputPort, times(1)).save(car);
    }

    @Test
    @DisplayName("Get Cars")
    void getCars() {
        List<Car> cars = List.of(generateCar(), generateCar(), generateCar());

        when(carCrudOutputPort.getList()).thenReturn(cars);

        List<Car> carsResponse = crudCarUseCase.getList();

        assertEquals(cars, carsResponse);
        verify(carCrudOutputPort, times(1)).getList();
    }

    @Test
    @DisplayName("Get Car")
    void getCar() {
        Car car = generateCar();

        when(carCrudOutputPort.get(car.getId())).thenReturn(Optional.of(car));

        Car carEntityResponse = crudCarUseCase.get(car.getId());

        assertEquals(car, carEntityResponse);
        verify(carCrudOutputPort, times(1)).get(car.getId());
    }

    @Test
    @DisplayName("Update Car")
    void updateCar() {
        Car car = generateCar();

        when(carCrudOutputPort.update(car)).thenReturn(car);

        Car updatedCar = crudCarUseCase.update(car);

        assertEquals(car, updatedCar);
        verify(carCrudOutputPort, times(1)).update(car);
    }

    @Test
    @DisplayName("Delete Car")
    void deleteCar() {
        Car car = generateCar();

        doNothing().when(carCrudOutputPort).delete(car.getId());

        crudCarUseCase.delete(car.getId());

        verify(carCrudOutputPort, times(1)).delete(car.getId());
    }

    private Car generateCar() {
        Car car = new Car();
        car.setId(UUID.randomUUID());
        car.setName("New Car");
        car.setColor("Red");
        car.setYear(2023);
        return car;
    }
}
