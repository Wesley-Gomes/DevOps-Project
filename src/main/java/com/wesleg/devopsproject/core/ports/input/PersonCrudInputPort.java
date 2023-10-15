package com.wesleg.devopsproject.core.ports.input;

import java.util.List;
import java.util.UUID;

import com.wesleg.devopsproject.core.domain.model.Person;

public interface PersonCrudInputPort {
   Person save(Person person);

   List<Person> getList();

   Person get(UUID personId);

   Person update(Person car);

   void delete(UUID personId);
}
