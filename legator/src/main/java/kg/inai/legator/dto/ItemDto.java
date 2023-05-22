package kg.inai.legator.dto;

import java.time.LocalDate;

public record ItemDto(
        long id,
        BookDto book,
        LocalDate issuedAt,
        LocalDate dueTo,
        LocalDate returnDate,
        String status
) {
}
