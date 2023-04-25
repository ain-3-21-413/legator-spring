package kg.inai.legator.entity.bibliographicrecord;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class ControlField {

    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    private Long id;
    private String tag;
    private String data;
}
