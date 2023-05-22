package kg.inai.legator.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Operation {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    Item item;

    @JoinColumn(name = "patron_id")
    @ManyToOne
    Patron patron;

    LocalDate issuedAt;

    LocalDate dueTo;
}
