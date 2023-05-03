package kg.inai.legator.repository.patron;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kg.inai.legator.entity.patron.Patron;

@Repository
public interface PatronRepository extends JpaRepository<Patron, String> {

    boolean existsByName(String email);
}
