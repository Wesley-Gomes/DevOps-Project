package com.wesleg.devopsproject.adapters.out.repository.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.wesleg.devopsproject.adapters.out.repository.entity.UserEntity;
import com.wesleg.devopsproject.core.domain.model.User;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
   UserEntity toUserEntity(User user);

   User toUser(UserEntity userEntity);

   List<User> toUserList(List<UserEntity> userEntityList);
}
