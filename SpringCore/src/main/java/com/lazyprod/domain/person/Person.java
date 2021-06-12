package com.lazyprod.domain.person;

public class Person {

    private String firstName;
    private String lastName;
    private Integer age;

    public Person(String firstName, Integer age) {
        this(firstName, null, age);
    }

    public Person(String firstName, String lastName) {
        this(firstName, lastName, null);
    }

    public Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("Person %s %s, age %d", firstName, lastName, age);
    }
}
