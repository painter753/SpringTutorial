package com.lazyprod.service.person;

import com.lazyprod.dao.person.PersonDao;
import com.lazyprod.domain.person.Person;
import com.lazyprod.service.io.IOService;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.mockito.Mockito.*;

@Epic("Person service implementation tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonServiceImplTest {

    private PersonDao personDao;
    private IOService ioService;
    private PersonService personService;

    @BeforeAll
    public void prepare() {
        this.personDao = mock(PersonDao.class);
        this.ioService = mock(IOService.class);

        this.personService = new PersonServiceImpl(personDao, ioService);
    }

    @Test
    public void testWelcomePerson() {
        String firstName = "bobby";
        String lastName = "brown";

        when(ioService.read()).thenReturn(firstName, lastName);
        when(personDao.getPerson(firstName, lastName)).thenReturn(new Person(firstName, lastName));

        personService.welcomePerson();

        verify(ioService, times(2)).read();
        verify(personDao).getPerson(firstName, lastName);
    }


}
