package kg.inai.legator.repository;

import kg.inai.legator.entity.OperationArchive;
import kg.inai.legator.entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationArchiveRepository extends JpaRepository<OperationArchive, Long> {
    List<OperationArchive> findAllByPatron(Patron patron);
}
