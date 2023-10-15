package com.wesleg.devopsproject.core.usecase;

import java.util.List;
import java.util.UUID;

import com.wesleg.devopsproject.core.domain.model.Person;
import com.wesleg.devopsproject.core.domain.exception.NotFoundException;
import com.wesleg.devopsproject.core.ports.input.PersonCrudInputPort;
import com.wesleg.devopsproject.core.ports.input.UserCrudInputPort;
import com.wesleg.devopsproject.core.ports.output.PersonCrudOutputPort;
import com.wesleg.devopsproject.core.utils.Utils;

public class PersonCrudUseCase implements PersonCrudInputPort {
    private final PersonCrudOutputPort personCrudOutputPort;
    private final UserCrudInputPort userCrudInputPort;

    public PersonCrudUseCase(PersonCrudOutputPort personCrudOutputPort,
                             UserCrudInputPort userCrudInputPort) {
        this.personCrudOutputPort = personCrudOutputPort;
        this.userCrudInputPort = userCrudInputPort;
    }

    @Override
    public Person save(Person person) {
        checkUsername(person.getUsername());
        return personCrudOutputPort.save(person);
    }

    @Override
    public List<Person> getList() {
        return personCrudOutputPort.getList();
    }

    @Override
    public Person get(UUID personId) {
        return personCrudOutputPort.get(personId).orElseThrow(() -> new NotFoundException("Person not found"));
    }

    @Override
    public Person update(Person person) {
        checkUsername(person.getUsername());
        Person personToUpdate = get(person.getId());
        Utils.updateObject(personToUpdate, person);
        return personCrudOutputPort.update(personToUpdate);
    }

    @Override
    public void delete(UUID personId) {
        personCrudOutputPort.delete(personId);
    }

    private void checkUsername(String username) {
        if (Boolean.FALSE.equals(userCrudInputPort.exists(username))) {
            throw new NotFoundException("User not found");
        }
    }
}
