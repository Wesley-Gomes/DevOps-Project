package com.wesleg.devopsproject.core.ports.input;

import java.util.List;
import com.wesleg.devopsproject.core.domain.model.User;

public interface UserCrudInputPort {
   void save(User user);

   List<User> getList();

   User get(String usarname);

   void updatePassword(String username, String password);

   void delete(String usarname);

   Boolean exists(String username);
}
