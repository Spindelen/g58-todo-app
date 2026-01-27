package se.lexicon.g58todoapp.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

// TODO IMPLEMENT: DONE
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

    public Attachment(@NonNull String fileName, @NonNull String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Attachment that = (Attachment) o;
        return id != 0 && id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
