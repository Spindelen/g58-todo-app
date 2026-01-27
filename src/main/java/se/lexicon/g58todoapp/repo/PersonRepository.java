package se.lexicon.g58todoapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.g58todoapp.entity.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    // TODO: Find person with a email :>>DONE
    List<Person> findByEmail(String email);
    // TODO: Is there a person with a specific email? - return boolean ;>>DONE
    boolean existsByEmail(String email);

}