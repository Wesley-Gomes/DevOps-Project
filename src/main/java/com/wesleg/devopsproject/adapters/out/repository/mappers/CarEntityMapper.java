package com.wesleg.devopsproject.adapters.out.repository.mappers;

import com.wesleg.devopsproject.adapters.out.repository.entity.CarEntity;
import com.wesleg.devopsproject.core.model.Car;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarEntityMapper {
    CarEntity toCarEntity(Car car);

    Car toCar(CarEntity carEntity);

    List<Car> toCarList(List<CarEntity> carEntityList);
}
