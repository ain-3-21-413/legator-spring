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
public class BookSubfield {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;

    String code;

    @Column(length = 1000)
    String value;

    @ManyToOne
    @JoinColumn(name = "book_field_id")
    BookField bookField;
}
