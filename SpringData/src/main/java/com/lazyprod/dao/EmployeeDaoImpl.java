package com.lazyprod.dao;

import com.lazyprod.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

    private JdbcOperations jdbcOperations;

    @Autowired
    public EmployeeDaoImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public boolean insert(String firstName, String lastName, String eMail) {
        int updated = jdbcOperations.update("INSERT INTO employees (first_name, last_name, email) VALUES (?,?,?)", firstName, lastName, eMail);
        return updated > 0;
    }

    @Override
    public Collection<Employee> findAll() {
        return jdbcOperations.query("select * from employees", (rs, i) -> Employee.builder()
                .id(rs.getInt(1))
                .firstName(rs.getString(2))
                .lastName(rs.getString(3))
                .eMail(rs.getString(4))
                .build());
    }

    @Override
    public Employee findById(int id) {
        return jdbcOperations.queryForObject("select * from employees where id = ?", (rs, i) -> Employee.builder()
                .id(rs.getInt(1))
                .firstName(rs.getString(2))
                .lastName(rs.getString(3))
                .eMail(rs.getString(4))
                .build(), id);
    }

    @Override
    public boolean deleteById(int id) {
        int updated = jdbcOperations.update("delete from employees where id = ?", id);
        return updated > 0;
    }

    @Override
    public int count() {
        return jdbcOperations.queryForObject("select count(*) from employees", Integer.class);
    }

}
