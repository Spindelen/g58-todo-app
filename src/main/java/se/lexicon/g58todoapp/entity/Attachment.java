package se.lexicon.g58todoapp.entity;


import jakarta.persistence.*;
import lombok.*;

// TODO IMPLEMENT
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @NonNull
    @Column(nullable = false, length = 100)
    private String fileName;

    @Setter
    @NonNull
    @Column(nullable = false, length = 100)
    private String fileType;

    @Column(nullable = false)
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "todo_id")
    private Todo todo;
}
