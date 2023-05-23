package kg.inai.legator.service;

import kg.inai.legator.dto.PatronDto;
import kg.inai.legator.dto.request.PatronRequest;

import java.util.List;

public interface PatronService {

    List<PatronDto> getPatrons();

    void addPatron(PatronDto patronDto);

    void updatePatron(String studentNumber, PatronRequest patronRequest);
}
