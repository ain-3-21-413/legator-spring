package kg.inai.legator.repository.bibliographicrecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kg.inai.legator.entity.bibliographicrecord.ControlField;

@Repository
public interface ControlFieldRepository extends JpaRepository<ControlField, Long> {

}
