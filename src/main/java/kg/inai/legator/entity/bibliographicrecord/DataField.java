package kg.inai.legator.entity.bibliographicrecord;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class DataField {

    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    private Long id;
    private String tag;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "data_field_id")
    private List<Subfield> subfields;
}
