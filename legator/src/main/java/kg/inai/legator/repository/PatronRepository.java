package kg.inai.legator.repository;

import jakarta.persistence.criteria.Predicate;
import kg.inai.legator.entity.Patron;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface PatronRepository extends JpaRepository<Patron, String> {

    default List<Patron> searchPatron(
            String firstName,
            String middleName,
            String lastName
    ) {
        return findAll(getSearchSpecification(firstName, middleName, lastName));
    }

    List<Patron> findAll(Specification<Patron> searchSpecification);

    private Specification<Patron> getSearchSpecification(
            String firstName,
            String middleName,
            String lastName
    ) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (firstName != null && !firstName.isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("firstName")),
                        "%" + firstName.toLowerCase() + "%"
                ));
            }

            if (middleName != null && !middleName.isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("middleName")),
                        "%" + middleName.toLowerCase() + "%"
                ));
            }

            if (lastName != null && !lastName.isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("lastName")),
                        "%" + lastName.toLowerCase() + "%"
                ));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
