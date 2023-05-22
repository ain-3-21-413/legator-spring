package kg.inai.legator.controller;

import kg.inai.legator.entity.Item;
import kg.inai.legator.entity.Operation;
import kg.inai.legator.entity.OperationArchive;
import kg.inai.legator.entity.Patron;
import kg.inai.legator.enums.EItemStatus;
import kg.inai.legator.repository.ItemRepository;
import kg.inai.legator.repository.OperationArchiveRepository;
import kg.inai.legator.repository.OperationRepository;
import kg.inai.legator.repository.PatronRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@RequestMapping("/api/circulation")
@RestController
public class CirculationController {

    final ItemRepository itemRepository;
    final PatronRepository patronRepository;
    final OperationRepository operationRepository;
    final OperationArchiveRepository operationArchiveRepository;

    @PostMapping("/check-out")
    public void checkout(@RequestParam("item-id") long itemId, @RequestParam("student-number") String studentNumber) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        if (!item.getStatus().equals(EItemStatus.AVAILABLE)) {
            throw new RuntimeException("not available");
        }
        Patron patron = patronRepository.findById(studentNumber).orElseThrow();
        Operation operation = operationRepository.save(new Operation());
        operation.setIssuedAt(LocalDate.now());
        operation.setDueTo(LocalDate.now().plusDays(30));
        operation.setItem(item);
        operation.setPatron(patron);
        item.setStatus(EItemStatus.CHECKED_OUT);
        operationRepository.save(operation);
    }

    @PostMapping("/check-in")
    public void checkIn(@RequestParam("item-id") long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        if (!item.getStatus().equals(EItemStatus.CHECKED_OUT)) {
            throw new RuntimeException("not checked out");
        }
        Operation operation = operationRepository.findByItem(item).orElseThrow();
        Patron patron = operation.getPatron();
        operation.setItem(null);
        operation.setPatron(null);
        item.setStatus(EItemStatus.AVAILABLE);
        operationRepository.save(operation);
        operationArchiveRepository.save(
                OperationArchive.builder()
                        .patron(patron)
                        .item(item)
                        .issuedAt(operation.getIssuedAt())
                        .dueTo(operation.getDueTo())
                        .returnDate(LocalDate.now())
                        .build()
        );
    }
}
