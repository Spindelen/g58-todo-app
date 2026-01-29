package se.lexicon.g58todoapp.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

// TODO IMPLEMENT: >>DONE<<
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "attachments")
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

    @Lob
    // 1KB = 1024 bytes
    // 1MB = 1024 X 1024 = 1048576 bytes
    // 10MB = 1048576 X10 = 10485760 bytes
    private byte[] data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "todo_id", nullable = false)
    private Todo todo;

    public Attachment(@NonNull String fileName, @NonNull String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;

        if (todo != null)
        todo.getAttachments().add(this);
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
