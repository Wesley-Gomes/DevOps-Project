package com.wesleg.devopsproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wesleg.devopsproject.adapters.out.PersonCrudAdapter;
import com.wesleg.devopsproject.core.usecase.PersonCrudUseCase;
import com.wesleg.devopsproject.core.usecase.UserCrudUseCase;

@Configuration
public class PersonCrudUseCaseConfig {
   @Bean
   public PersonCrudUseCase personCrudUseCase(PersonCrudAdapter personCrudAdapter,
                                              UserCrudUseCase userCrudUseCase) {
      return new PersonCrudUseCase(personCrudAdapter, userCrudUseCase);
   }
}
