package kg.inai.legator.dto;

import java.util.List;

public record BookDto(
        long id,
        List<BookFieldDto> fields
) {
    public record BookFieldDto(
            String name,
            String value
    ) {
    }

}
