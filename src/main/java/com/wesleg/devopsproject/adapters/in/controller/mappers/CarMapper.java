package com.wesleg.devopsproject.adapters.in.controller.mappers;

import com.wesleg.devopsproject.adapters.in.controller.reponse.CarResponse;
import com.wesleg.devopsproject.adapters.in.controller.request.CarRequest;
import com.wesleg.devopsproject.core.domain.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Car toCar(CarRequest carRequest);

    CarResponse toCarResponse(Car car);

    List<CarResponse> toCarResponseList(List<Car> carList);
}
