package kg.inai.legator.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kg.inai.legator.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}
