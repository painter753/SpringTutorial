package com.lazyprod.service.person;

import com.lazyprod.dao.person.PersonDao;
import com.lazyprod.domain.person.Person;
import com.lazyprod.service.io.IOService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;
    private IOService ioService;

    public PersonServiceImpl(PersonDao personDao, IOService ioService) {
        this.personDao = personDao;
        this.ioService = ioService;
    }

    public Person welcomePerson() {
        ioService.writeLocalizedMessage("message.person.welcome");
        ioService.writeLocalizedMessage("message.person.first-name");

        String firstName = ioService.read();
        ioService.writeLocalizedMessage("message.person.last-name");
        String lastName = ioService.read();

        return this.personDao.getPerson(firstName, lastName);
    }

    @Override
    public Person getPersonByName(String name) {
        return personDao.findPersonByName(name);
    }
}
