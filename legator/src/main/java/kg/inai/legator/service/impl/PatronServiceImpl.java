package kg.inai.legator.service.impl;

import kg.inai.legator.dto.PatronDto;
import kg.inai.legator.dto.request.PatronRequest;
import kg.inai.legator.entity.Patron;
import kg.inai.legator.entity.PatronGroup;
import kg.inai.legator.exception.GroupNotFoundException;
import kg.inai.legator.exception.PatronGroupNotFoundException;
import kg.inai.legator.exception.PatronNotFoundException;
import kg.inai.legator.exception.StudentNumberTakenException;
import kg.inai.legator.mapper.PatronMapper;
import kg.inai.legator.repository.PatronGroupRepository;
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
    final PatronGroupRepository patronGroupRepository;
    final PatronMapper patronMapper;

    @Override
    public List<PatronDto> getPatronsByGroup(String patronGroupName) {
        PatronGroup patronGroup = patronGroupRepository.findById(patronGroupName).orElseThrow(() -> new PatronGroupNotFoundException(patronGroupName));
        return patronGroup.getPatrons().stream().map(patronMapper::toDto).toList();
    }

    @Override
    public List<PatronDto> getPatrons() {
        return patronRepository.findAll().stream().map(patronMapper::toDto).toList();
    }

    @Override
    public void saveOrUpdatePatron(PatronDto patronDto) {
        Patron patron = null;
        Optional<Patron> optionalPatron = patronRepository.findById(patronDto.studentNumber());
        if (optionalPatron.isEmpty()) {
            patron = patronRepository.save(patronMapper.toEntity(patronDto));
        } else {
            patron = patronMapper.toEntity(patronDto);
        }
        if (patronDto.group() != null) {
            PatronGroup patronGroup = patronGroupRepository.findById(patronDto.group()).orElseThrow(() -> new GroupNotFoundException(patronDto.group()));
            patronGroup.addPatron(patron);
            patronGroupRepository.save(patronGroup);
        }
    }

    @Override
    public void addPatron(PatronDto patronDto) {
        if (patronRepository.existsById(patronDto.studentNumber())) {
            throw new StudentNumberTakenException(patronDto.studentNumber());
        }
        Patron patron = patronRepository.save(patronMapper.toEntity(patronDto));
        if (patronDto.group() != null) {
            PatronGroup patronGroup = patronGroupRepository.findById(patronDto.group()).orElseThrow(() -> new GroupNotFoundException(patronDto.group()));
            patronGroup.addPatron(patron);
            patronGroupRepository.save(patronGroup);
        }
    }

    @Override
    public void updatePatron(String studentNumber, PatronRequest patronRequest) {
        Patron patron = patronRepository.findById(studentNumber).orElseThrow(() -> new PatronNotFoundException(studentNumber));
        patron = patronMapper.toEntity(patron.getStudentNumber(), patronRequest);
        patronRepository.save(patron);
    }
}
