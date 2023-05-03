package kg.inai.legator.entity.itemtransaction;

import jakarta.persistence.*;
import kg.inai.legator.entity.Librarian;
import kg.inai.legator.entity.item.ItemRecord;
import kg.inai.legator.entity.patron.Patron;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ItemTransaction {

    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    Long id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patron_id")
    Patron patron;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "librarian_id")
    Librarian librarian;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_record_id")
    ItemRecord itemRecord;

    @Enumerated(EnumType.STRING)
    ItemTransactionType itemTransactionType;
    
    Date issuesAt;
    
    Date expectedEnd;
    
    Date actualEnd;
}
