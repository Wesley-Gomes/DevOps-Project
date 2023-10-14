package com.wesleg.devopsproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wesleg.devopsproject.adapters.out.CarCrudAdapter;
import com.wesleg.devopsproject.core.usecase.CarCrudUseCase;

@Configuration
public class CarCrudUseCaseConfig {
   @Bean
   public CarCrudUseCase carCrudUseCase(CarCrudAdapter carCrudAdapter) {
      return new CarCrudUseCase(carCrudAdapter);
   }   
}
