package se.lexicon.g58todoapp.entity;


import jakarta.persistence.Entity;
import lombok.*;

// TODO IMPLEMENT
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class Attachment {

    private long id;
    private String fileName;
    private String fileType;
    private byte[] data;
}
