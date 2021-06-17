package com.lazyprod.service.person;

import com.lazyprod.dao.person.PersonDao;
import com.lazyprod.domain.person.Person;
import com.lazyprod.service.io.IOService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import java.util.Locale;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;
    private IOService ioService;

    public PersonServiceImpl(PersonDao personDao, IOService ioService) {
        this.personDao = personDao;
        this.ioService = ioService;
    }

    public Person welcomePerson() {
        ioService.writeLocalized("message.person.welcome", Locale.GERMANY);
        ioService.writeLocalized("message.person.first-name", Locale.GERMANY);

        String firstName = ioService.read();
        ioService.writeLocalized("message.person.last-name", Locale.GERMANY);
        String lastName = ioService.read();

        return this.personDao.getPerson(firstName, lastName);
    }

    @Override
    public Person getPersonByName(String name) {
        return personDao.findPersonByName(name);
    }
}
