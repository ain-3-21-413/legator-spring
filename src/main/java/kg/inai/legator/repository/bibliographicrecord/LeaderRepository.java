package kg.inai.legator.repository.bibliographicrecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kg.inai.legator.entity.bibliographicrecord.Leader;

@Repository
public interface LeaderRepository extends JpaRepository<Leader, Long> {

}
