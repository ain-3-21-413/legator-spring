package kg.inai.legator.repository.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kg.inai.legator.entity.item.ItemRecordStatus;

@Repository
public interface ItemRecordStatusRepository extends JpaRepository<ItemRecordStatus, Integer> {

}
