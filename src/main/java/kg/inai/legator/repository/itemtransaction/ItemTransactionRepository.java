package kg.inai.legator.repository.itemtransaction;

import kg.inai.legator.entity.item.ItemRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kg.inai.legator.entity.itemtransaction.ItemTransaction;

import java.util.Optional;

@Repository
public interface ItemTransactionRepository extends JpaRepository<ItemTransaction, Long> {

    Optional<ItemTransaction> findByItemRecord(ItemRecord itemRecord);
}
