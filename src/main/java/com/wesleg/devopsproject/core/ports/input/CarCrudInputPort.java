package com.wesleg.devopsproject.core.ports.input;

import com.wesleg.devopsproject.core.domain.model.Car;

import java.util.List;
import java.util.UUID;

public interface CarCrudInputPort {
    Car save(Car car);

    List<Car> getList();

    Car get(UUID carId);

    Car update(Car car);

    void delete(UUID carId);
}
