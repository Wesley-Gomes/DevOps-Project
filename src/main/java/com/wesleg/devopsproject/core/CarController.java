package com.wesleg.devopsproject.core;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
@Tag(name = "Car")
public class CarController {
    private final CarService carService;

    @PostMapping
    public void createCar(@RequestBody Car car) {
        carService.createCar(car);
    }

    @GetMapping
    public List<Car> getCars() {
        return carService.getCars();
    }

    @GetMapping("/{carId}")
    public Car getCar(@PathVariable Long carId) {
        return carService.getCar(carId);
    }

    @PutMapping
    public void updateCar(@RequestBody Car car) {
        carService.updateCar(car);
    }

    @DeleteMapping("/{carId}")
    public void deleteCar(@PathVariable Long carId) {
        carService.deleteCar(carId);
    }
}
