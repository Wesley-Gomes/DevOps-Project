package com.wesleg.devopsproject.adapters.out;

import com.wesleg.devopsproject.adapters.out.repository.entity.CarEntity;
import com.wesleg.devopsproject.adapters.out.repository.mappers.CarEntityMapper;
import com.wesleg.devopsproject.core.domain.Car;
import com.wesleg.devopsproject.core.ports.output.CarCrudOutputPort;
import com.wesleg.devopsproject.adapters.out.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Component
@RequiredArgsConstructor
public class CarCrudAdapter implements CarCrudOutputPort {
    private final CarRepository carRepository;
    private final CarEntityMapper carEntityMapper;

    @Override
    public Car save(Car car) {
        return saveInRepository(car);
    }

    @Override
    public List<Car> getList() {
        return carEntityMapper.toCarList(carRepository.findAll().stream().toList());
    }

    @Override
    public Optional<Car> get(UUID carId) {
        return carRepository.findById(carId).map(carEntityMapper::toCar);
    }

    @Override
    public Car update(Car car) {
        return saveInRepository(car);
    }

    @Override
    public void delete(UUID carId) {
        carRepository.deleteById(carId);
    }

    private Car saveInRepository(Car car) {
        CarEntity carEntity = carEntityMapper.toCarEntity(car);
        return carEntityMapper.toCar(carRepository.save(carEntity));
    }
}
