package com.lazyprod.service;

import com.lazyprod.dao.EmployeeDao;
import com.lazyprod.domain.Employee;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Collection;
import java.util.stream.Stream;

@ShellComponent
public class CommandService {

    private EmployeeDao employeeDao;

    public CommandService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @ShellMethod("Add two integers together.")
    public int add(int a, int b) {
        return a + b;
    }

    @ShellMethod("Say hello.")
    public void greet(@ShellOption(defaultValue = "anonymos") String user) {
        System.out.println("Hello, " + user);
    }

    @ShellMethod("Show employees count")
    public int count() {
        return employeeDao.count();
    }

    @ShellMethod("Delete employees")
    public boolean delete(int id) {
        return employeeDao.deleteById(id);
    }

    @ShellMethod("Insert employee")
    public boolean insert(String firstName, String lastName, String eMail) {
        return employeeDao.insert(firstName, lastName, eMail);
    }

    @ShellMethod("Find employee by id")
    public void find(int id) {
        System.out.println(employeeDao.findById(id));
    }

    @ShellMethod("Find all employees")
    public void findAll() {
        Collection<Employee> employees = employeeDao.findAll();
        employees.stream().forEach(System.out::println);
    }

}
