package kg.inai.legator.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class OperationArchive {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;

    @ManyToOne
    @JoinColumn(name = "patron_id")
    Patron patron;

    @ManyToOne
    @JoinColumn(name = "item_id")
    Item item;

    LocalDate issuedAt;

    LocalDate dueTo;

    LocalDate returnDate;
}
