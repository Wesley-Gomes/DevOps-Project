package com.wesleg.devopsproject.adapters.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wesleg.devopsproject.adapters.in.controller.mappers.PersonMapper;
import com.wesleg.devopsproject.adapters.in.controller.reponse.PersonResponse;
import com.wesleg.devopsproject.adapters.in.controller.request.PersonRequest;
import com.wesleg.devopsproject.core.domain.model.Person;
import com.wesleg.devopsproject.core.ports.input.PersonCrudInputPort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
@Tag(name = "Person")
public class PersonController {
    private final PersonCrudInputPort personCrudInputPort;
    private final PersonMapper personMapper;

    @PostMapping
    public ResponseEntity<PersonResponse> createPerson(@RequestBody PersonRequest personRequest) {
        Person person = personRequestToPerson(personRequest);
        Person createdPerson = personCrudInputPort.save(person);
        return ResponseEntity.ok().body(personToPersonResponse(createdPerson));
    }

    @GetMapping
    public ResponseEntity<List<PersonResponse>> getPersons() {
        return ResponseEntity.ok().body(personListToPersonResponseList(personCrudInputPort.getList()));
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonResponse> getPerson(@PathVariable UUID personId) {
        return ResponseEntity.ok().body(personToPersonResponse(personCrudInputPort.get(personId)));
    }

    @PutMapping("/{personId}")
    public ResponseEntity<PersonResponse> updatePerson(@PathVariable UUID personId, @RequestBody PersonRequest personRequest) {
        Person person = personRequestToPerson(personRequest);
        person.setId(personId);
        Person updatedPerson = personCrudInputPort.update(person);
        return ResponseEntity.ok().body(personToPersonResponse(updatedPerson));
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<Void> deletePerson(@PathVariable UUID personId) {
        personCrudInputPort.delete(personId);
        return ResponseEntity.noContent().build();
    }

    private Person personRequestToPerson(PersonRequest personRequest) {
        return personMapper.toPerson(personRequest);
    }

    private PersonResponse personToPersonResponse(Person person) {
        return personMapper.toPersonResponse(person);
    }

    private List<PersonResponse> personListToPersonResponseList(List<Person> personList) {
        return personMapper.toPersonResponseList(personList);
    }

}
