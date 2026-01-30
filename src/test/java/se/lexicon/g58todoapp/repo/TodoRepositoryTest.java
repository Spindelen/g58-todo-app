package se.lexicon.g58todoapp.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.g58todoapp.entity.Person;
import se.lexicon.g58todoapp.entity.Todo;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private PersonRepository personRepository;

    private Person testPerson;
    private LocalDateTime now;

    @BeforeEach
    void setUp() {
        // Create a test person
        testPerson = new Person("Test Person", "test@example.com");
        testPerson = personRepository.save(testPerson);

        now = LocalDateTime.now();
    }

    @Test
    @DisplayName("Save Todo should persist the Todo and return it with generated ID")
    void saveTodo_ShouldPersistTodo() {
        Todo newTodo = new Todo("New Task", "Description", now.plusDays(1));
        Todo saved = todoRepository.save(newTodo);

        assertNotNull(saved.getId());
        assertEquals("New Task", saved.getTitle());
        assertEquals("Description", saved.getDescription());
        assertFalse(saved.getCompleted());
        assertEquals(now.plusDays(1).withNano(0), saved.getDueDate().withNano(0));


    }


    //TODO - Implement more tests.

    @Test
    @DisplayName("Find Todos containing case-insensitive title substring should return matching Todos")
    void findByTitleContainingIgnoreCase_ShouldReturnMatchingTodos() {
        assertTrue(false);
    }

    @Test
    @DisplayName("Find Todos by Person ID should return that person's Todos")
    void findByPerson_Id_ShouldReturnPersonsTodos() {
        assertTrue(false);
    }

    @Test
    @DisplayName("Find Todos by completion status should return completed Todos")
    void findByCompleted_ShouldReturnCompletedTodos() {
        assertTrue(false);
    }

    @Test
    @DisplayName("Find Todos due within a date range should return matching Todos")
    void findByDueDateBetween_ShouldReturnTodosInDateRange() {
        assertTrue(false);
    }

    @Test
    @DisplayName("Find overdue and incomplete Todos should return matching Todos")
    void findByDueDateBeforeAndCompletedFalse_ShouldReturnOverdueTodos() {
        assertTrue(false);
    }

    @Test
    @DisplayName("Find unassigned Todos should return Todos with no Person set")
    void findByPersonIsNull_ShouldReturnUnassignedTodos() {
        assertTrue(false);
    }

    @Test
    @DisplayName("Find unfinished overdue Todos should return matching Todos")
    void findByCompletedFalseAndDueDateBefore_ShouldReturnUnfinishedOverdueTasks() {
        assertTrue(false);
    }

    @Test
    @DisplayName("Find completed Todos for a Person by ID should return matching Todos")
    void findByPersonIdAndCompletedTrue_ShouldReturnCompletedTasksForPerson() {
        assertTrue(false);
    }

    @Test
    @DisplayName("Find Todos with no due date should return matching Todos")
    void findByDueDateIsNull_ShouldReturnTodosWithNoDueDate() {
        assertTrue(false);
    }


    @Test
    @DisplayName("Count Todos for a Person by ID should return correct count")
    void countByPersonId_ShouldReturnCorrectCount() {
        assertTrue(false);
    }


}