package com.wesleg.devopsproject.core.ports.output;

import com.wesleg.devopsproject.core.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarCrudOutputPort {
    Car save(Car car);

    List<Car> getList();

    Optional<Car> get(Long carId);

    Car update(Car car);

    void delete(Long carId);
}
