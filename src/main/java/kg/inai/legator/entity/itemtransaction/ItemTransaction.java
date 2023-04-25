package kg.inai.legator.entity.itemtransaction;

import kg.inai.legator.entity.Librarian;
import kg.inai.legator.entity.item.ItemRecord;
import kg.inai.legator.entity.patron.Patron;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_transaction_type_id")
    ItemTransactionType itemTransactionType;
    
    Date issuesAt;
    
    Date expectedEnd;
    
    Date actualEnd;
}
