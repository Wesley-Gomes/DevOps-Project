package com.wesleg.devopsproject.adapters.out.repository.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import com.wesleg.devopsproject.adapters.out.repository.entity.PersonEntity;
import com.wesleg.devopsproject.core.domain.model.Person;

@Mapper(componentModel = "spring")
public interface PersonEntityMapper {
   PersonEntity toPersonEntity(Person person);

   Person toPerson(PersonEntity personEntity);

   List<Person> toPersonList(List<PersonEntity> personEntityList);
}
