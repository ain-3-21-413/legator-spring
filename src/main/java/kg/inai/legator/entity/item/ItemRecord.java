package kg.inai.legator.entity.item;

import jakarta.persistence.*;
import kg.inai.legator.entity.bibliographicrecord.BibliographicRecord;
import kg.inai.legator.entity.patron.Patron;
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
public class ItemRecord {

    @Id
    String number;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bibliographic_record_id")
    BibliographicRecord bibliographicRecord;

    @Enumerated(EnumType.STRING)
    ItemRecordStatus itemRecordStatus;

    @Enumerated(EnumType.STRING)
    AccessLevel accessLevel;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patron_id")
    Patron patron;
}
