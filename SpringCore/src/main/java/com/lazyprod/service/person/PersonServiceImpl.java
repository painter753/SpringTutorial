package com.lazyprod.service.person;

import com.lazyprod.dao.person.PersonDao;
import com.lazyprod.domain.person.Person;
import com.lazyprod.service.io.IOService;

public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;
    private IOService ioService;

    public PersonServiceImpl(PersonDao personDao, IOService ioService) {
        this.personDao = personDao;
        this.ioService = ioService;
    }

    public Person welcomePerson() {
        ioService.write("Welcome! Enter your credentials.\n");
        ioService.write("Enter your first name:\n");

        String firstName = ioService.read();
        ioService.write("Enter your last name:\n");
        String lastName = ioService.read();

        return this.personDao.getPerson(firstName, lastName);
    }

    @Override
    public Person getPersonByName(String name) {
        return personDao.findPersonByName(name);
    }
}
