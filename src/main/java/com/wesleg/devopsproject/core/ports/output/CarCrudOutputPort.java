package com.wesleg.devopsproject.core.ports.output;

import com.wesleg.devopsproject.core.domain.Car;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarCrudOutputPort {
    Car save(Car car);

    List<Car> getList();

    Optional<Car> get(UUID carId);

    Car update(Car car);

    void delete(UUID carId);
}
