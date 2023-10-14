package com.wesleg.devopsproject.adapters.in.controller.mappers;

import org.mapstruct.Mapper;

import com.wesleg.devopsproject.adapters.in.controller.request.UserRequest;
import com.wesleg.devopsproject.core.domain.model.User;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
   @Mapping(target = "createdAt", ignore = true)
   User toUser(UserRequest userRequest);
}
