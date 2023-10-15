package com.wesleg.devopsproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wesleg.devopsproject.adapters.out.UserCrudAdapter;
import com.wesleg.devopsproject.core.usecase.UserCrudUseCase;

@Configuration
public class UserCrudUseCaseConfig {
   @Bean
   public UserCrudUseCase userCrudUseCase(UserCrudAdapter userCrudAdapter) {
      return new UserCrudUseCase(userCrudAdapter);
   }   
}
