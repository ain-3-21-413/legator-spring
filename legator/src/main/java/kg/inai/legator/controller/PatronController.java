package kg.inai.legator.controller;


import kg.inai.legator.dto.ItemDto;
import kg.inai.legator.dto.PatronDto;
import kg.inai.legator.dto.request.PatronRequest;
import kg.inai.legator.entity.Patron;
import kg.inai.legator.enums.EItemStatus;
import kg.inai.legator.mapper.ItemMapper;
import kg.inai.legator.mapper.PatronMapper;
import kg.inai.legator.repository.ItemRepository;
import kg.inai.legator.repository.OperationArchiveRepository;
import kg.inai.legator.repository.PatronRepository;
import kg.inai.legator.service.PatronService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/patrons")
@RestController
public class PatronController {

    final PatronService patronService;
    final PatronRepository patronRepository;
    final ItemRepository itemRepository;
    final ItemMapper itemMapper;
    final OperationArchiveRepository operationArchiveRepository;
    final PatronMapper patronMapper;

    @GetMapping
    public List<PatronDto> getPatrons() {
        return patronService.getPatrons();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addPatron(@RequestBody PatronDto patronDto) {
        patronService.addPatron(patronDto);
    }

    @PutMapping("/{student-number}")
    public void updatePatron(@PathVariable("student-number") String studentNumber, @RequestBody PatronRequest patronRequest) {
        patronService.updatePatron(studentNumber, patronRequest);
    }

    @GetMapping("/{student-number}/items")
    public List<ItemDto> getCheckedOutItemsByPatron(@PathVariable("student-number") String studentNumber) {
        Patron patron = patronRepository.findById(studentNumber).orElseThrow();
        return itemRepository.findAllByStatusAndOperation_Patron(EItemStatus.CHECKED_OUT, patron).stream().map(itemMapper::toItemDto).toList();
    }

    @GetMapping("/{student-number}/archive")
    public List<ItemDto> getCheckOutHistory(@PathVariable("student-number") String studentNumber) {
        Patron patron = patronRepository.findById(studentNumber).orElseThrow();
        return operationArchiveRepository.findAllByPatron(patron).stream().map(itemMapper::toItemDto).toList();
    }

    @PostMapping("/search")
    public List<PatronDto> search(@RequestBody PatronDto patronDto) {
        return patronRepository.searchPatron(
                patronDto.firstName(),
                patronDto.middleName(),
                patronDto.lastName()
        ).stream().map(patronMapper::toDto).toList();
    }
}
