package se.lexicon.g58todoapp.confiq;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.lexicon.g58todoapp.entity.Attachment;
import se.lexicon.g58todoapp.entity.Person;
import se.lexicon.g58todoapp.entity.Todo;
import se.lexicon.g58todoapp.repo.AttachmentRepository;
import se.lexicon.g58todoapp.repo.PersonRepository;
import se.lexicon.g58todoapp.repo.TodoRepository;

import javax.print.DocFlavor;
import java.time.LocalDateTime;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner run(PersonRepository personRepository, TodoRepository todoRepository, AttachmentRepository attachmentRepository){
        return args -> {

            Person dev1 = personRepository.save(new Person("Dev1", "dev1@test.se"));
            Person dev2 = personRepository.save(new Person("Dev2", "dev2@test.se"));
            Person dev3 = personRepository.save(new Person("Dev3", "dev3@test.se"));

            LocalDateTime now = LocalDateTime.now();
            Todo todo1 = new Todo("Shopping", "Buy groceries", now.plusDays(1));
            Todo todo2 = new Todo("Reading", "Read book: Java for Beginners", now.plusDays(5));
            Todo todo3 = new Todo("Studying", "Study for exam", now.plusDays(3));
            Todo todo4 = new Todo("Go To Gym", "Workout session"); // No due date
            Todo todo5 = new Todo("Clean bike", "Maintenance", now.plusHours(12));
            Todo todo6 = new Todo("Clean Car", "Wash and vacuum", now.plusDays(1));

            Attachment file1 = new Attachment("unit-test-guide.pdf", "application/pdf", "Sample PDF Content".getBytes());
            file1.setTodo(todo2);

            Attachment file2 = new Attachment("mock-test.png", "image/png", "sample image".getBytes());
            todo2.addAttachment(file2);

        };
    }



}
