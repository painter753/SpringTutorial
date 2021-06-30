package com.lazyprod.dao;

import com.lazyprod.domain.Employee;

import java.util.Collection;

public interface EmployeeDao {

    boolean insert(String firstName, String lastName, String eMail);
    Collection<Employee> findAll();
    Employee findById(int id);
    boolean deleteById(int id);
    int count();

}
