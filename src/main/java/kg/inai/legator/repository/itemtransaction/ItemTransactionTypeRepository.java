package kg.inai.legator.repository.itemtransaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kg.inai.legator.entity.itemtransaction.ItemTransactionType;

@Repository
public interface ItemTransactionTypeRepository extends JpaRepository<ItemTransactionType, Integer> {

}
