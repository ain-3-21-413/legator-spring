package kg.inai.legator.service;

import kg.inai.legator.dto.PatronDto;

import java.util.List;

public interface PatronService {

    List<PatronDto> getPatronsByGroup(String patronGroupName);

    List<PatronDto> getPatrons();

    void saveOrUpdatePatron(PatronDto patronDto);

    boolean existsPatronByStudentNumber(String studentNumber);
}
