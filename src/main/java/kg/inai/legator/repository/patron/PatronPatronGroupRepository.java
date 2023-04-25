package kg.inai.legator.repository.patron;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kg.inai.legator.entity.patron.PatronPatronGroup;

@Repository
public interface PatronPatronGroupRepository extends JpaRepository<PatronPatronGroup, Long> {

}
