package com.lazyprod.service;

import com.lazyprod.dao.PersonDao;
import com.lazyprod.domain.Person;

public class PersonServiceImpl implements PersonService {

    private PersonDao dao;

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    @Override
    public Person getByName(String name) {
        return dao.findByName(name);
    }
}
