package kg.inai.legator.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class BookField {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;

    String name;

    String value;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;
}
