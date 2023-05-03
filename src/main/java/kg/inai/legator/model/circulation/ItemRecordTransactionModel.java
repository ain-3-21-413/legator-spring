package kg.inai.legator.model.circulation;

import java.sql.Date;

public record ItemRecordTransactionModel(

    String patronId,
    String librarianId,
    String itemRecordId,
    int itemTransactionTypeId,
    Date issuesAt,
    Date expectedEnd,
    Date actualEnd
) {

}
