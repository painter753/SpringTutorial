package com.lazyprod.dao.person;

import com.lazyprod.domain.person.Person;
import com.lazyprod.service.io.IOService;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

@Epic("Person dao simple ")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonDaoSimpleTest {

    private IOService ioService;
    private PersonDao personDao;

    @BeforeAll
    public void prepare() {
        this.ioService = Mockito.mock(IOService.class);
        this.personDao = new PersonDaoSimple(ioService);
    }

    @Test
    @DisplayName("Get person test")
    public void testGetPerson() {
        String firstName = "Bobby";
        String lastName = "Brown";

        Person person = personDao.getPerson(firstName, lastName);

        Assertions.assertAll(
                () -> Assertions.assertEquals(firstName, person.getFirstName()),
                () -> Assertions.assertEquals(lastName, person.getLastName())
        );
    }
}
