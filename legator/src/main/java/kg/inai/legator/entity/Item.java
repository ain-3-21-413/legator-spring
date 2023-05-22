package kg.inai.legator.entity;

import jakarta.persistence.*;
import kg.inai.legator.enums.EItemStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Item {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;

    @Enumerated(EnumType.STRING)
    EItemStatus status = EItemStatus.AVAILABLE;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;

    @OneToOne(mappedBy = "item")
    Operation operation;

    @OneToMany(mappedBy = "item")
    List<OperationArchive> operationArchives = new ArrayList<>();
}
