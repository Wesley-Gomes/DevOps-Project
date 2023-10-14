package com.wesleg.devopsproject.adapters.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.wesleg.devopsproject.adapters.out.repository.PersonRepository;
import com.wesleg.devopsproject.adapters.out.repository.entity.PersonEntity;
import com.wesleg.devopsproject.adapters.out.repository.mappers.PersonEntityMapper;
import com.wesleg.devopsproject.core.domain.model.Person;
import com.wesleg.devopsproject.core.ports.output.PersonCrudOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PersonCrudAdapter implements PersonCrudOutputPort {
   private final PersonRepository personRepository;
   private final PersonEntityMapper personEntityMapper;

   @Override
   public Person save(Person person) {
      return saveInRepository(person);
   }

   @Override
   public List<Person> getList() {
      return personEntityMapper.toPersonList(personRepository.findAll().stream().toList());
   }

   @Override
   public Optional<Person> get(UUID personId) {
      return personRepository.findById(personId).map(personEntityMapper::toPerson);
   }

   @Override
   public Person update(Person person) {
      return saveInRepository(person);
   }

   @Override
   public void delete(UUID personId) {
      personRepository.deleteById(personId);
   }

   private Person saveInRepository(Person person) {
      PersonEntity personEntity = personEntityMapper.toPersonEntity(person);
      return personEntityMapper.toPerson(personRepository.save(personEntity));
   }
}
