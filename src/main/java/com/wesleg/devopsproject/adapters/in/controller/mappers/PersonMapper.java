package com.wesleg.devopsproject.adapters.in.controller.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.wesleg.devopsproject.adapters.in.controller.reponse.PersonResponse;
import com.wesleg.devopsproject.adapters.in.controller.request.PersonRequest;
import com.wesleg.devopsproject.core.domain.model.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
   @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
   Person toPerson(PersonRequest personRequest);

   PersonResponse toPersonResponse(Person person);

   List<PersonResponse> toPersonResponseList(List<Person> personList);
}
