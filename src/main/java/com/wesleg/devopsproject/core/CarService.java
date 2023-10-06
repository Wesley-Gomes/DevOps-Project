package com.wesleg.devopsproject.core;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public void createCar(Car car) {
        carRepository.save(car);
    }

    public List<Car> getCars() {
        return carRepository.findAll().stream().toList();
    }

    public Car getCar(Long carId) {
        return carRepository.findById(carId).orElse(null);
    }

    public void updateCar(Car car) {
        carRepository.save(car);
    }

    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }
}
