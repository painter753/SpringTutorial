package com.lazyprod;

import com.lazyprod.domain.Person;
import com.lazyprod.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        PersonService service = context.getBean(PersonService.class);

        Person person = service.getByName("somename");
        System.out.println(person);
    }

}
