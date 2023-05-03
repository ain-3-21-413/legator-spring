package kg.inai.legator.service.impl;

import kg.inai.legator.entity.item.ItemRecord;
import kg.inai.legator.entity.item.ItemRecordStatus;
import kg.inai.legator.entity.itemtransaction.ItemTransaction;
import kg.inai.legator.entity.itemtransaction.ItemTransactionType;
import kg.inai.legator.model.circulation.OutModel;
import kg.inai.legator.repository.LibrarianRepository;
import kg.inai.legator.repository.item.ItemRecordRepository;
import kg.inai.legator.repository.itemtransaction.ItemTransactionRepository;
import kg.inai.legator.repository.patron.PatronRepository;
import kg.inai.legator.service.CirculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;


@RequiredArgsConstructor
@Service
public class CirculationServiceImpl implements CirculationService {

    private final PatronRepository patronRepository;
    private final ItemTransactionRepository itemTransactionRepository;
    private final ItemRecordRepository itemRecordRepository;
    private final LibrarianRepository librarianRepository;

    @Override
    public boolean checkOut(OutModel checkOutModel) {
        ItemRecord itemRecord = itemRecordRepository.findById(checkOutModel.itemId()).orElseThrow();
        if (!itemRecord.getItemRecordStatus().equals(ItemRecordStatus.AVAILABLE)) {
            throw new RuntimeException("taken");
        }
        itemRecord.setItemRecordStatus(ItemRecordStatus.CHECKED_OUT);
        itemRecordRepository.save(itemRecord);
        itemTransactionRepository.save(
                ItemTransaction.builder()
                        .patron(
                                patronRepository.findById(checkOutModel.patronNumber()).orElseThrow()
                        )
                        .itemRecord(itemRecord)
                        .librarian(
                                librarianRepository.findById(checkOutModel.librarianNumber()).orElseThrow()
                        )
                        .issuesAt(checkOutModel.issuesAt())
                        .expectedEnd(checkOutModel.expectedEnd())
                        .itemTransactionType(
                                ItemTransactionType.CHECK_OUT
                        )
                        .build()
        );
        return true;
    }

    @Override
    public boolean checkIn(String number) {
        ItemRecord itemRecord = itemRecordRepository.findById(number).orElseThrow();
        ItemTransaction itemTransaction = itemTransactionRepository.findByItemRecord(itemRecord).orElseThrow();
        if (!itemTransaction.getItemTransactionType().equals(ItemTransactionType.CHECK_OUT)) {
            throw new RuntimeException("");
        }
        itemRecord.setItemRecordStatus(ItemRecordStatus.AVAILABLE);
        itemTransaction.setItemTransactionType(ItemTransactionType.CHECK_IN);
        itemTransaction.setActualEnd(new Date());
        itemTransactionRepository.save(itemTransaction);
        itemRecordRepository.save(itemRecord);
        return true;
    }

    @Override
    public boolean hold(OutModel holdModel) {
        ItemRecord itemRecord = itemRecordRepository.findById(holdModel.itemId()).orElseThrow();
        if (!itemRecord.getItemRecordStatus().equals(ItemRecordStatus.AVAILABLE)) {
            throw new RuntimeException("taken");
        }
        itemRecord.setItemRecordStatus(ItemRecordStatus.HOLD);
        itemRecordRepository.save(itemRecord);
        itemTransactionRepository.save(
                ItemTransaction.builder()
                        .patron(
                                patronRepository.findById(holdModel.patronNumber()).orElseThrow()
                        )
                        .itemRecord(itemRecord)
                        .librarian(
                                librarianRepository.findById(holdModel.librarianNumber()).orElseThrow()
                        )
                        .issuesAt(holdModel.issuesAt())
                        .expectedEnd(holdModel.expectedEnd())
                        .itemTransactionType(
                                ItemTransactionType.HOLD
                        )
                        .build()
        );
        return true;
    }

    @Override
    public boolean unhold(String number) {
        ItemRecord itemRecord = itemRecordRepository.findById(number).orElseThrow();
        ItemTransaction itemTransaction = itemTransactionRepository.findByItemRecord(itemRecord).orElseThrow();
        if (!itemTransaction.getItemTransactionType().equals(ItemTransactionType.HOLD)) {
            throw new RuntimeException("");
        }
        itemRecord.setItemRecordStatus(ItemRecordStatus.AVAILABLE);
        itemTransaction.setItemTransactionType(ItemTransactionType.UNHOLD);
        itemTransaction.setActualEnd(new Date());
        itemTransactionRepository.save(itemTransaction);
        itemRecordRepository.save(itemRecord);
        return true;
    }

}
