package com.lazyprod.dao;

import com.lazyprod.domain.Person;

public class PersonDaoSimple implements PersonDao {
    @Override
    public Person findByName(String name) {
        return new Person(name, 0);
    }
}
