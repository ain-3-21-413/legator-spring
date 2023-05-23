package kg.inai.legator.repository;

import jakarta.persistence.criteria.Predicate;
import kg.inai.legator.entity.Patron;
import kg.inai.legator.enums.EHomeroom;
import kg.inai.legator.enums.EPatronGroup;
import kg.inai.legator.enums.ESex;
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
            String lastName,
            String patronGroup,
            String sex,
            String homeroom,
            String secondLocation,
            String primaryEmail,
            String instituteEmail,
            String primaryPhone,
            String mobile,
            String messengers
    ) {
        return findAll(getSearchSpecification(
                firstName,
                middleName,
                lastName,
                patronGroup,
                sex,
                homeroom,
                secondLocation,
                primaryEmail,
                instituteEmail,
                primaryPhone,
                mobile,
                messengers
        ));
    }

    List<Patron> findAll(Specification<Patron> searchSpecification);

    private Specification<Patron> getSearchSpecification(
            String firstName,
            String middleName,
            String lastName,
            String patronGroup,
            String sex,
            String homeroom,
            String secondLocation,
            String primaryEmail,
            String instituteEmail,
            String primaryPhone,
            String mobile,
            String messengers
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

            if (patronGroup != null && !patronGroup.isEmpty()) {
                predicates.add(criteriaBuilder.equal(
                        root.get("patronGroup"), EPatronGroup.valueOf(patronGroup))
                );
            }

            if (sex != null && !sex.isEmpty()) {
                predicates.add(criteriaBuilder.equal(
                        root.get("sex"), ESex.valueOf(sex))
                );
            }

            if (homeroom != null && !homeroom.isEmpty()) {
                predicates.add(criteriaBuilder.equal(
                        root.get("homeroom"), EHomeroom.valueOf(homeroom))
                );
            }
            if (secondLocation != null && !secondLocation.isEmpty()) {
                predicates.add(criteriaBuilder.equal(
                        root.get("patronGroup"), EHomeroom.valueOf(secondLocation))
                );
            }

            if (primaryEmail != null && !primaryEmail.isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("primaryEmail")),
                        "%" + primaryEmail.toLowerCase() + "%"
                ));
            }

            if (primaryEmail != null && !primaryEmail.isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("primaryEmail")),
                        "%" + primaryEmail.toLowerCase() + "%"
                ));
            }

            if (instituteEmail != null && !instituteEmail.isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("instituteEmail")),
                        "%" + instituteEmail.toLowerCase() + "%"
                ));
            }

            if (mobile != null && !mobile.isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("mobile")),
                        "%" + mobile.toLowerCase() + "%"
                ));
            }

            if (messengers != null && !messengers.isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("messengers")),
                        "%" + messengers.toLowerCase() + "%"
                ));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
