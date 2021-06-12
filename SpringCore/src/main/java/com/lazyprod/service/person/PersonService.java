package com.lazyprod.service.person;

import com.lazyprod.domain.person.Person;

public interface PersonService {

    Person getPersonByName(String name);
    Person welcomePerson();

}
