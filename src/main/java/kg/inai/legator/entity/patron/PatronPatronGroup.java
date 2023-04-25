package kg.inai.legator.entity.patron;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PatronPatronGroup {

    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patron_id")
    Patron patron;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patron_group_id")
    PatronGroup patronGroup;
}
