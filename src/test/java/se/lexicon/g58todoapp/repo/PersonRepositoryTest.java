package se.lexicon.g58todoapp.repo;

import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.g58todoapp.entity.Person;


import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;



    @Test
    @DisplayName("Save and find by email")
    void testSaveAndFindByEmail() {
        // Arrange
        Person person = new Person("John Doe", "john.doe@example.com");
        personRepository.save(person);

        // Act
        var retrievedPerson = personRepository.findByEmail("john.doe@example.com");

        // Assert
        assertTrue(retrievedPerson.isPresent());
        assertEquals("John Doe", retrievedPerson.get().getName());
        assertEquals("john.doe@example.com", retrievedPerson.get().getEmail());

    }

    @Test
    @DisplayName("Retrieve all persons from the repository")
    void testFindAllPersons() {

        //Arrange
        Person person1 = new Person("Charlie", "charlie@example.com");
        Person person2 = new Person("Dana", "dana@example.com");
        personRepository.save(person1);
        personRepository.save(person2);

        //Act
        var all = personRepository.findAll();

        //Assert
        assertEquals(2, all.size());

    }

    //TODO - Students
    @Test
    @DisplayName("Exists by email should return true")
    void testExistsByEmail() {

        assertTrue(false);
    }

    //TODO - Students
    @Test
    @DisplayName("Exists by email should return false for unknown email")
    void testExistsByEmailFalse() {
        assertTrue(false);
    }

    @Test
    @DisplayName("Delete a person by email and verify existence")
    void testDeletePersonByEmail() {
        assertTrue(false);

    }






}