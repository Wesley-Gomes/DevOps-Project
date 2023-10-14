package com.wesleg.devopsproject.core.usecase;

import com.wesleg.devopsproject.core.domain.model.Car;
import com.wesleg.devopsproject.core.domain.exception.NotFoundException;
import com.wesleg.devopsproject.core.ports.input.CarCrudInputPort;
import com.wesleg.devopsproject.core.ports.output.CarCrudOutputPort;
import com.wesleg.devopsproject.core.utils.Utils;

import java.util.List;
import java.util.UUID;

public class CarCrudUseCase implements CarCrudInputPort {
    private final CarCrudOutputPort carCrudOutputPort;

    public CarCrudUseCase(CarCrudOutputPort carCrudOutputPort) {
        this.carCrudOutputPort = carCrudOutputPort;
    }

    @Override
    public Car save(Car car) {
        return carCrudOutputPort.save(car);
    }

    @Override
    public List<Car> getList() {
        return carCrudOutputPort.getList();
    }

    @Override
    public Car get(UUID carId) {
        return carCrudOutputPort.get(carId).orElseThrow(() -> new NotFoundException("Car not found"));
    }

    @Override
    public Car update(Car car) {
        Car carToUpdate = get(car.getId());
        Utils.updateObject(carToUpdate, car);
        return carCrudOutputPort.update(carToUpdate);
    }

    @Override
    public void delete(UUID carId) {
        carCrudOutputPort.delete(carId);
    }
}
