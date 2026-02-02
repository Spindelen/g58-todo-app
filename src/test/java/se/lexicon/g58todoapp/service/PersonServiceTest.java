package se.lexicon.g58todoapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import se.lexicon.g58todoapp.entity.Person;
import se.lexicon.g58todoapp.repo.PersonRepository;
import se.lexicon.notify.model.Email;
import se.lexicon.notify.service.MessageService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class PersonServiceTest {

    @Mock
    PersonRepository personRepository;

    @Mock
    MessageService<Email> messageService;

    @InjectMocks
    PersonService personService;


    private Person person;

    private final Long TEST_ID = 1L;
    private final String TEST_NAME = "Simon Elbrink";
    private final String TEST_EMAIL = "erik@manboy.se";

    @BeforeEach
    void setUp() {
        person = new Person(TEST_ID,TEST_NAME, TEST_EMAIL, LocalDate.parse("2026-01-01"), null);

    }

    @Test
    void findAll() {
        //Arrange
        Person person2 = new Person( "Mehrdad Javan", "erik@manboy.se");
        List<Person> list= Arrays.asList(person, person2);
        when(personRepository.findAll()).thenReturn(list); // if this method is called give this response ^ ( Mocking Data)

        //Act
        List<Person> result = personService.findAll();


        //Assert
        assertEquals(2, result.size());
        assertEquals(TEST_NAME, result.get(0).getName());
        assertEquals(TEST_EMAIL, result.get(0).getEmail());

        verify(personRepository).findAll(); // Verify that this method was actually called.

    }

    @Test
    void testCreate() {
        //Arrange
        when(personRepository.save(any(Person.class))).thenReturn(person);

        //Act
        personService.createPerson(person);

        //Assert
        verify(personRepository).save(any(Person.class));
        verify(messageService).sendMessage(any(Email.class));

    }

    @Test
    void findById() {
        //TODO - Implement Test  >>>DONE<<<
        //Arrange
        Person person3 = new Person(3L,"Test person", "test@test.se");
        when(personRepository.findById(3L)).thenReturn(Optional.of(person3));

        //ACT
        Person result = personService.findById(3L);

        //Assert
        assertEquals("Test person", result.getName());
        assertEquals("test@test.se", result.getEmail());
        assertEquals(3L, result.getId());
        verify(personRepository).findById(3L);

    }

    @Test
    void update() {   //Todo: >>>DONE<<<
        when(personRepository.findById(TEST_ID)).thenReturn(Optional.of(person));
        when(personRepository.save(person)).thenReturn(person);

        Person personUpdate = new Person(null, "Test person", "test@test.se", LocalDate.parse("2026-01-01"), null);

        Person result = personService.Update(TEST_ID, personUpdate);

        assertEquals("Test person", result.getName());
        assertEquals("test@test.se", result.getEmail());
        verify(personRepository).save(person);

    }

    @Test
    void deleteById() {      //todo: >>>DONE<<<
        //Arrange
        when(personRepository.findById(TEST_ID)).thenReturn(Optional.of(person));

        //Act
        personService.deleteById(TEST_ID);

        //Assert
        verify(personRepository).delete(person);




    }

    @Test
    void findByEmail() {   //Todo: >>>DONE<<<
        //Arrange
        Person person3 = new Person(3L,"Test person", "test@test.nu");
        when(personRepository.findByEmail("test@test.nu")).thenReturn(Optional.of(person3));

        //ACT
        Person result = personService.findByEmail("test@test.nu");

        //Assert
        assertEquals("test@test.nu", result.getEmail());
        verify(personRepository).findByEmail("test@test.nu");
    }
}