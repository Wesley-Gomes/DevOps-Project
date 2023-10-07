package com.wesleg.devopsproject.core.ports.input;

import com.wesleg.devopsproject.core.model.Car;

import java.util.List;

public interface CarCrudInputPort {
    Car save(Car car);

    List<Car> getList();

    Car get(Long carId);

    Car update(Car car);

    void delete(Long carId);
}
