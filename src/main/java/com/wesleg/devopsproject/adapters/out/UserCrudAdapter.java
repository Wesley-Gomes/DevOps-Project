package com.wesleg.devopsproject.adapters.out;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

import com.wesleg.devopsproject.adapters.out.repository.UserRepository;
import com.wesleg.devopsproject.adapters.out.repository.entity.UserEntity;
import com.wesleg.devopsproject.adapters.out.repository.mappers.UserEntityMapper;
import com.wesleg.devopsproject.core.domain.model.User;
import com.wesleg.devopsproject.core.ports.output.UserCrudOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserCrudAdapter implements UserCrudOutputPort {
   private final UserRepository userRepository;
   private final UserEntityMapper userEntityMapper;

   @Override
   public void save(User user) {
      saveInRepository(user);
   }

   @Override
   public List<User> getList() {
      return userEntityMapper.toUserList(userRepository.findAll().stream().toList());
   }

   @Override
   public Optional<User> get(String username) {
      return userRepository.findById(username).map(userEntityMapper::toUser);
   }

   @Override
   public void updatePassword(User user) {
      saveInRepository(user);
   }

   @Override
   public void delete(String username) {
      userRepository.deleteById(username);
   }

   private void saveInRepository(User user) {
      UserEntity userEntity = userEntityMapper.toUserEntity(user);
      userEntityMapper.toUser(userRepository.save(userEntity));
   }
}
