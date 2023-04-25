package kg.inai.legator.entity.itemtransaction;

import kg.inai.legator.entity.Librarian;
import kg.inai.legator.entity.item.ItemRecord;
import kg.inai.legator.entity.patron.Patron;

import java.util.Date;

public class ItemTransaction {
    int id;
    Patron patron;
    Librarian librarian;
    ItemRecord itemRecord;
    ItemTransactionType itemTransactionType;
    Date issuesAt;
    Date expectedEnd;
    Date actualEnd;
}
