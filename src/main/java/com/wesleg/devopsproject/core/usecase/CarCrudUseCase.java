package com.wesleg.devopsproject.core.usecase;

import com.wesleg.devopsproject.core.model.Car;
import com.wesleg.devopsproject.core.ports.input.CarCrudInputPort;
import com.wesleg.devopsproject.core.ports.output.CarCrudOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CarCrudUseCase implements CarCrudInputPort {
    private final CarCrudOutputPort carCrudOutputPort;

    @Override
    public Car save(Car car) {
        return carCrudOutputPort.save(car);
    }

    @Override
    public List<Car> getList() {
        return carCrudOutputPort.getList();
    }

    @Override
    public Car get(Long carId) {
        return carCrudOutputPort.get(carId).orElseThrow(() -> new RuntimeException("Car not found"));
    }

    @Override
    public Car update(Car car) {
        return carCrudOutputPort.update(car);
    }

    @Override
    public void delete(Long carId) {
        carCrudOutputPort.delete(carId);
    }
}
