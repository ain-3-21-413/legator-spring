package kg.inai.legator.repository.bibliographicrecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kg.inai.legator.entity.bibliographicrecord.Subfield;

@Repository
public interface SubfieldRepository extends JpaRepository<Subfield, Long> {

}
