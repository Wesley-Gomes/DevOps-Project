package com.wesleg.devopsproject.adapters.in.controller;

import com.wesleg.devopsproject.adapters.in.controller.mappers.CarMapper;
import com.wesleg.devopsproject.adapters.in.controller.reponse.CarResponse;
import com.wesleg.devopsproject.adapters.in.controller.request.CarRequest;
import com.wesleg.devopsproject.core.model.Car;
import com.wesleg.devopsproject.core.ports.input.CarCrudInputPort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
@Tag(name = "Car")
public class CarController {
    private final CarCrudInputPort carCrudInputPort;
    private final CarMapper carMapper;

    @PostMapping
    public ResponseEntity<CarResponse> createCar(@RequestBody CarRequest carRequest) {
        Car car = carRequesttoCar(carRequest);
        Car createdCar = carCrudInputPort.save(car);
        return ResponseEntity.ok().body(carToCarResponse(createdCar));
    }

    @GetMapping
    public ResponseEntity<List<CarResponse>> getCars() {
        return ResponseEntity.ok().body(carListToCarResponseList(carCrudInputPort.getList()));
    }

    @GetMapping("/{carId}")
    public ResponseEntity<CarResponse> getCar(@PathVariable Long carId) {
        return ResponseEntity.ok().body(carToCarResponse(carCrudInputPort.get(carId)));
    }

    @PutMapping("/{carId}")
    public ResponseEntity<CarResponse> updateCar(@PathVariable Long carId, @RequestBody CarRequest carRequest) {
        Car car = carRequesttoCar(carRequest);
        car.setId(carId);
        Car updatedCar = carCrudInputPort.update(car);
        return ResponseEntity.ok().body(carToCarResponse(updatedCar));
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long carId) {
        carCrudInputPort.delete(carId);
        return ResponseEntity.noContent().build();
    }

    private Car carRequesttoCar(CarRequest carRequest) {
        return carMapper.toCar(carRequest);
    }

    private CarResponse carToCarResponse(Car car) {
        return carMapper.toCarResponse(car);
    }

    private List<CarResponse> carListToCarResponseList(List<Car> carList) {
        return carMapper.toCarResponseList(carList);
    }
}
