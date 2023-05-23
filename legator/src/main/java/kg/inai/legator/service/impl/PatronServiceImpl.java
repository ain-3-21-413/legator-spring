package kg.inai.legator.service.impl;

import kg.inai.legator.dto.PatronDto;
import kg.inai.legator.dto.request.PatronRequest;
import kg.inai.legator.entity.Patron;
import kg.inai.legator.exception.PatronNotFoundException;
import kg.inai.legator.exception.StudentNumberTakenException;
import kg.inai.legator.mapper.PatronMapper;
import kg.inai.legator.repository.PatronRepository;
import kg.inai.legator.service.PatronService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class PatronServiceImpl implements PatronService {

    final PatronRepository patronRepository;
    final PatronMapper patronMapper;

    @Override
    public List<PatronDto> getPatrons() {
        return patronRepository.findAll().stream().map(patronMapper::toDto).toList();
    }

    @Override
    public void addPatron(PatronDto patronDto) {
        if (patronRepository.existsById(patronDto.studentNumber())) {
            throw new StudentNumberTakenException(patronDto.studentNumber());
        }
        Patron patron = patronRepository.save(patronMapper.toEntity(patronDto));
        patronRepository.save(patron);
    }

    @Override
    public void updatePatron(String studentNumber, PatronRequest patronRequest) {
        Patron patron = patronRepository.findById(studentNumber).orElseThrow(() -> new PatronNotFoundException(studentNumber));
        patron = patronMapper.toEntity(patron.getStudentNumber(), patronRequest);
        patronRepository.save(patron);
    }
}
