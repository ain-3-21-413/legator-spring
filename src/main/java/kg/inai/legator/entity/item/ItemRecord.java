package kg.inai.legator.entity.item;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_record_status_id")
    ItemRecordStatus itemRecordStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "access_level_id")
    AccessLevel accessLevel;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patron_id")
    Patron patron;
}
