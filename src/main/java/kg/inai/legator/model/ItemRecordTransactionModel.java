package kg.inai.legator.model;

import java.sql.Date;

public record ItemRecordTransactionModel(

	Long id,
    String patronId,
    String librarianId,
    String itemRecordId,
    int itemTransactionTypeId,
    Date issuesAt,
    Date expectedEnd,
    Date actualEnd
) {

}
