package kg.inai.legator.repository;

import kg.inai.legator.entity.Item;
import kg.inai.legator.entity.Operation;
import kg.inai.legator.entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    Optional<Operation> findByItemAndPatron(Item item, Patron patron);

    Optional<Operation> findByItem(Item item);
}
