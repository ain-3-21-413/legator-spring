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
public class Leader {

    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    private Long id;
    private int recordLength;
    private char recordStatus;
    private char typeOfRecord;
    private String implDefined1;
    private char charCodingScheme;
    private int indicatorCount;
    private int subfieldCodeLength;
    private int baseAddressOfData;
    private String implDefined2;
    private String entryMap;
}
