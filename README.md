# Todo Application


## Objective
This is a simple yet functional Todo Application built using Spring Boot and JPA. The app allows users (persons) to
manage tasks, track completion status, and monitor due dates. Tasks can be assigned to specific users or left
unassigned. The application automatically records creation and update timestamps for each task. It is designed with a
clean architecture and follows best practices in Java development.


### Class Diagram

````mermaid

classDiagram
    class Person{
        - Long id
        - String name
        - String email
        - LocalDate birthDate
        - LocalDate createdAt
        
        + Person(name, email, birthDate)
        // getters, setters, toString, equals, hashCode
    }
    class Todo{
        - Long id
        - String title
        - String description
        - boolean completed
        - LocalDate createdAt
        - LocalDate updatedAt
        - LocalDate dueDate
        - Person assignedTo
        - Set~Attachment~ attachments
        
        + Task(title, description, dueDate)
        + Task(title, description, dueDate, assignedTo)
        // getters, setters, toString, equals, hashCode
    }

    class Attachment {
        - Long id
        - String fileName
        - String fileType
        - byte[] data
        - Todo todo
    }
    
    
    %% Relationships
    Person "0..1" --> "0..*" Todo : assignedToATask  - ManyToOne
    Todo "0..1" <--> "0..*" Attachment : hasAttachments - OneToMany



````