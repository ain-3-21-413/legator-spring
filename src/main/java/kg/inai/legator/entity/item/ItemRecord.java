package kg.inai.legator.entity.item;

import kg.inai.legator.entity.bibliographicrecord.BibliographicRecord;
import kg.inai.legator.entity.patron.Patron;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ItemRecord {
    String number;
    BibliographicRecord bibliographicRecord;
    ItemRecordStatus itemRecordStatus;
    AccessLevel accessLevel;
    Patron patron;
}
