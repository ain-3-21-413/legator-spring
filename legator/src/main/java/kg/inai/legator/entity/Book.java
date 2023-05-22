package kg.inai.legator.entity;

import jakarta.persistence.*;
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
public class Book {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    List<BookField> bookFields = new ArrayList<>();
}
