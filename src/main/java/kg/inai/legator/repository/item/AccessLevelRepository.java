package kg.inai.legator.repository.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kg.inai.legator.entity.item.AccessLevel;

@Repository
public interface AccessLevelRepository extends JpaRepository<AccessLevel, Integer> {

}
