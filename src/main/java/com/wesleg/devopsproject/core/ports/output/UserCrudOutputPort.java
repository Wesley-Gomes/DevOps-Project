package com.wesleg.devopsproject.core.ports.output;

import java.util.List;
import java.util.Optional;
import com.wesleg.devopsproject.core.domain.model.User;

public interface UserCrudOutputPort {
   void save(User user);

   List<User> getList();

   Optional<User> get(String username);

   void updatePassword(User user);

   void delete(String username);
}
