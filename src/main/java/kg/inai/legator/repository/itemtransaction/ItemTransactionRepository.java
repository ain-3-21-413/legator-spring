package kg.inai.legator.repository.itemtransaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kg.inai.legator.entity.itemtransaction.ItemTransaction;

@Repository
public interface ItemTransactionRepository extends JpaRepository<ItemTransaction, Long> {

}
