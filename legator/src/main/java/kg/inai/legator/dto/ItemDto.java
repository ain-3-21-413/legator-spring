package kg.inai.legator.dto;

import java.time.LocalDate;

public record ItemDto(
        long id,
        BookDto book,
        PatronDto patron,
        LocalDate issuedAt,
        LocalDate dueTo,
        LocalDate returnDate,
        String status
) {
}
