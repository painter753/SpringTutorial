package com.lazyprod.dao;

import com.lazyprod.domain.Person;

public interface PersonDao {

    public Person findByName(String name);

}
