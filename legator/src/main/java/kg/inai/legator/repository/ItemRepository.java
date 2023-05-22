package kg.inai.legator.repository;

import kg.inai.legator.entity.Book;
import kg.inai.legator.entity.Item;
import kg.inai.legator.entity.Patron;
import kg.inai.legator.enums.EItemStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByStatus(EItemStatus eItemStatus);

    List<Item> findAllByStatusAndOperation_Patron(EItemStatus eItemStatus, Patron patron);

    List<Item> findAllByBook(Book book);
}
