package kg.inai.legator.repository.patron;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kg.inai.legator.entity.patron.PatronGroup;

@Repository
public interface PatronGroupRepository extends JpaRepository<PatronGroup, Integer> {

}
