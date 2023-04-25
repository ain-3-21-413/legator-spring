package kg.inai.legator.entity.bibliographicrecord;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class BibliographicRecord {

    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "leader_id")
    private Leader leader;

    @JoinColumn(name = "bibliographic_record_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<ControlField> controlFields;

    @JoinColumn(name = "bibliographic_record_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<DataField> dataFields;
}
