package com.lazyprod.dao.person;

import com.lazyprod.domain.person.Person;

public interface PersonDao {

    Person findPersonByName(String name);
    Person getPerson(String firstName, String lastName);

}
