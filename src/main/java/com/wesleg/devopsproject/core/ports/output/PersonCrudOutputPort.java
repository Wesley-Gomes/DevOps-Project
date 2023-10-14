package com.wesleg.devopsproject.core.ports.output;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.wesleg.devopsproject.core.domain.model.Person;

public interface PersonCrudOutputPort {
   Person save(Person person);

   List<Person> getList();

   Optional<Person> get(UUID personId);

   Person update(Person car);

   void delete(UUID personId);
}
