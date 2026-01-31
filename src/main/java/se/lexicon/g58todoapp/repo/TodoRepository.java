package se.lexicon.g58todoapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.g58todoapp.entity.Person;
import se.lexicon.g58todoapp.entity.Todo;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {


    // 🔍 Find todos by title keyword (case-insensitive contains)
    List<Todo> findByTitleContainingIgnoreCase(String title);
    // SELECT * FROM todos WHERE LOWER(title) LIKE LOWER(CONCAT('%', :title, '%'));

    // 👤 Find todos by person ID
    List<Todo> findByAssignedTo_Id(Long personId);
    // SELECT * FROM todos WHERE person_id = :personId;

    // ✅ Find todos by completed status
    List<Todo> findByCompleted(boolean completed);
    // SELECT * FROM todos WHERE completed = :completed;

    // 🗓️ Find todos between two due dates
    List<Todo> findByDueDateBetween(LocalDateTime start, LocalDateTime end);
    // SELECT * FROM todos WHERE due_date BETWEEN :start AND :end;
    // select * from todos where due_date >= :start and due_date <= :end;

    // 🗓️ Find todos due before a specific date and not completed
    List<Todo> findByDueDateBeforeAndCompletedFalse(LocalDateTime dateTime);
    // select * from todos where due_date < :dateTime and completed = false;

    // ❌ Find unassigned todos (person is null)
    List<Todo> findByAssignedToIsNull();
    // select * from todos where person_id is null;

    // 🔥 Find unfinished and overdue tasks (custom query)
    List<Todo> findByCompletedFalseAndDueDateBefore(LocalDateTime dateTime);
    // select * from todos where completed = false and due_date < :dateTime;

    // ✅ Find completed tasks assigned to a specific person
    List<Todo> findByAssignedTo_IdAndCompletedTrue(Long personId);
    // select * from todos where person_id = :personId and completed = true;

    // 📅 Find all with no due date
    List<Todo> findByDueDateIsNull();
    // select * from todos where due_date is null;

    // 📌 Count all tasks assigned to a person
    long countByAssignedTo_Id(Long personId);

    List<Todo> countTodosByAssignedTo(Person assignedTo);
    // select count(*) from todos where person_id = :personId;

}