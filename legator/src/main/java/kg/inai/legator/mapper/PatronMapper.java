package kg.inai.legator.mapper;

import kg.inai.legator.dto.PatronDto;
import kg.inai.legator.dto.request.PatronRequest;
import kg.inai.legator.entity.Patron;

public interface PatronMapper {

    PatronDto toDto(Patron patron);

    Patron toEntity(PatronDto patronDto);

    Patron toEntity(String studentNumber, PatronRequest patronRequest);
}
