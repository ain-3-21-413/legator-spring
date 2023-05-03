package kg.inai.legator.model.circulation;

import java.sql.Date;

public record OutModel(
        String patronNumber,
        String itemId,
        String librarianNumber,
        Date issuesAt,
        Date expectedEnd
) {
}
