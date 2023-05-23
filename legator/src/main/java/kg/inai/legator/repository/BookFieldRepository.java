package kg.inai.legator.repository;

import kg.inai.legator.entity.Book;
import kg.inai.legator.entity.BookField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookFieldRepository extends JpaRepository<BookField, Long> {
    Optional<BookField> findByName(String name);

    Optional<BookField> findByNameAndBook(String s, Book newBook);

    @Query("SELECT f FROM BookField f WHERE f.name = :name and f.value LIKE %:value%")
    List<BookField> customFind(String name, String value);
}
