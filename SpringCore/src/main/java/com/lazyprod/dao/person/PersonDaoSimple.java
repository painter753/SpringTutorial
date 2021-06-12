package com.lazyprod.dao.person;

import com.lazyprod.domain.person.Person;
import com.lazyprod.service.io.IOService;

public class PersonDaoSimple implements PersonDao {

    private IOService ioService;

    public PersonDaoSimple(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public Person findPersonByName(String name) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Person getPerson(String firstName, String lastName) {
            return new Person(firstName, lastName);
    }
}
