package kg.inai.legator.repository.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kg.inai.legator.entity.item.ItemRecord;

@Repository
public interface ItemRecordRepository extends JpaRepository<ItemRecord, String> {

}
