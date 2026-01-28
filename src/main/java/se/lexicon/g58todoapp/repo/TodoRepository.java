package se.lexicon.g58todoapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.g58todoapp.entity.Attachment;
import se.lexicon.g58todoapp.entity.Person;
import se.lexicon.g58todoapp.entity.Todo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
    
    // TODO : Tasks assigned to a specific Person >>DONE<<

    List<Todo> findByAssignedTo(Person person);
    List<Todo> findByTitleContainingIgnoreCase(String title);

    // TODO : 📌 Count all tasks assigned to a person >>DONE<<

    Long countByAssignedTo(Person person);

    // TODO : ✅ Find completed tasks assigned to a specific person >>DONE<<

    List<Todo> findByAssignedToAndCompleted(Person person, boolean completed);

    // TODO : 🔍 Find todos by title keyword (case-insensitive contains) >>DONE<<

    List<Todo> findByTitleIgnoreCaseContaining(String keyword);

    // TODO : ✅ Find todos by completed status >>DONE<<

    List<Todo> findByCompleted(boolean completed);
    //unsure we dont have a status

    // TODO : 🗓️ Find todos between two due dates >>DONE<<

    List<Todo> findByDueDateBetween(LocalDateTime dueDateAfter, LocalDateTime dueDateBefore);

    // TODO :️ Find todo due before a specific date and not completed >>DONE<<

    List<Todo> findByDueDateBeforeAndCompletedFalse(LocalDateTime dueDateBefore, Boolean completed);

    // TODO :🔥 Find unfinished and overdue task >>DONE<<

    List<Todo> findByCompletedFalseAndDueDateBefore(LocalDateTime now);

    // TODO : Find tasks that are not assigned to anyone >>DONE<<

    List<Todo> findByAssignedToIsNull();

    // TODO : 📅 Find all with no due date >>DONE<<

    List<Todo> findAllByDueDateEmpty(LocalDateTime dueDate);
}