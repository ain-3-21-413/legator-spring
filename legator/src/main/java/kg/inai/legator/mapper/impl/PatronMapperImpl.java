package kg.inai.legator.mapper.impl;

import kg.inai.legator.dto.PatronDto;
import kg.inai.legator.dto.request.PatronRequest;
import kg.inai.legator.entity.Patron;
import kg.inai.legator.enums.*;
import kg.inai.legator.exception.InvalidSelectOptionException;
import kg.inai.legator.mapper.PatronMapper;
import org.springframework.stereotype.Component;

@Component
public class PatronMapperImpl implements PatronMapper {

    @Override
    public PatronDto toDto(Patron patron) {

        if (patron == null) {
            return null;
        }

        return PatronDto.builder()
                .studentNumber(patron.getStudentNumber())
                .firstName(patron.getFirstName())
                .middleName(patron.getMiddleName())
                .lastName(patron.getLastName())
                .library(patron.getLibrary() == null ? null : patron.getLibrary().name())
                .status(patron.getStatus() == null ? null : patron.getStatus().name())
                .policy(patron.getPolicy() == null ? null : patron.getPolicy().name())
                .birthDate(patron.getBirthDate())
                .sex(patron.getSex() == null ? null : patron.getSex().name())
                .homeroom(patron.getHomeroom() == null ? null : patron.getHomeroom().name())
                .secondLocation(patron.getSecondLocation() == null ? null : patron.getSecondLocation().name())
                .group(patron.getPatronGroup() == null ? "" : patron.getPatronGroup().name())
                .graduationDate(patron.getGraduationDate())
                .accountExpiration(patron.getAccountExpiration())
                .primaryEmail(patron.getPrimaryEmail())
                .instituteEmail(patron.getInstituteEmail())
                .primaryPhone(patron.getPrimaryPhone())
                .mobile(patron.getMobile())
                .messengers(patron.getMessengers())
                .address1(patron.getAddress1())
                .address2(patron.getAddress2())
                .contactNotes(patron.getContactNotes())
                .username(patron.getUsername())
                .password(patron.getPassword())
                .generalNotes(patron.getGeneralNotes())
                .alertNotes(patron.getAlertNotes())
                .build();
    }

    @Override
    public Patron toEntity(PatronDto patronDto) {

        if (patronDto == null) {
            return null;
        }

        ELibrary library = null;
        EPatronStatus status = null;
        EPatronPolicy policy = null;
        ESex sex = null;
        EHomeroom homeroom = null;
        EHomeroom secondLocation = null;
        EPatronGroup group = null;

        if (patronDto.library() != null) {
            try {
                library = ELibrary.valueOf(patronDto.library());
            } catch (IllegalArgumentException e) {
                throw new InvalidSelectOptionException();
            }
        }
        if (patronDto.status() != null) {
            try {
                status = EPatronStatus.valueOf(patronDto.status());
            } catch (IllegalArgumentException e) {
                throw new InvalidSelectOptionException();
            }
        }
        if (patronDto.policy() != null) {
            try {
                policy = EPatronPolicy.valueOf(patronDto.policy());
            } catch (IllegalArgumentException e) {
                throw new InvalidSelectOptionException();
            }
        }
        if (patronDto.sex() != null) {
            try {
                sex = ESex.valueOf(patronDto.sex());
            } catch (IllegalArgumentException e) {
                throw new InvalidSelectOptionException();
            }
        }
        if (patronDto.homeroom() != null) {
            try {
                homeroom = EHomeroom.valueOf(patronDto.homeroom());
            } catch (IllegalArgumentException e) {
                throw new InvalidSelectOptionException();
            }
        }
        if (patronDto.secondLocation() != null) {
            try {
                secondLocation = EHomeroom.valueOf(patronDto.secondLocation());
            } catch (IllegalArgumentException e) {
                throw new InvalidSelectOptionException();
            }
        }

        if (patronDto.group() != null) {
            try {
                group = EPatronGroup.valueOf(patronDto.group());
            } catch (IllegalArgumentException e) {
                throw new InvalidSelectOptionException();
            }
        }

        return Patron.builder()
                .studentNumber(patronDto.studentNumber())
                .firstName(patronDto.firstName())
                .middleName(patronDto.middleName())
                .lastName(patronDto.lastName())
                .library(library)
                .status(status)
                .policy(policy)
                .birthDate(patronDto.birthDate())
                .sex(sex)
                .homeroom(homeroom)
                .secondLocation(secondLocation)
                .graduationDate(patronDto.graduationDate())
                .accountExpiration(patronDto.accountExpiration())
                .primaryEmail(patronDto.primaryEmail())
                .instituteEmail(patronDto.instituteEmail())
                .primaryPhone(patronDto.primaryPhone())
                .mobile(patronDto.mobile())
                .messengers(patronDto.messengers())
                .address1(patronDto.address1())
                .address2(patronDto.address2())
                .contactNotes(patronDto.contactNotes())
                .username(patronDto.username())
                .password(patronDto.password())
                .generalNotes(patronDto.generalNotes())
                .alertNotes(patronDto.alertNotes())
                .patronGroup(group)
                .build();
    }

    @Override
    public Patron toEntity(String studentNumber, PatronRequest patronRequest) {
        if (patronRequest == null) {
            return null;
        }

        ELibrary library = null;
        EPatronStatus status = null;
        EPatronPolicy policy = null;
        ESex sex = null;
        EHomeroom homeroom = null;
        EHomeroom secondLocation = null;

        if (patronRequest.library() != null) {
            try {
                library = ELibrary.valueOf(patronRequest.library());
            } catch (IllegalArgumentException e) {
                throw new InvalidSelectOptionException();
            }
        }
        if (patronRequest.status() != null) {
            try {
                status = EPatronStatus.valueOf(patronRequest.status());
            } catch (IllegalArgumentException e) {
                throw new InvalidSelectOptionException();
            }
        }
        if (patronRequest.policy() != null) {
            try {
                policy = EPatronPolicy.valueOf(patronRequest.policy());
            } catch (IllegalArgumentException e) {
                throw new InvalidSelectOptionException();
            }
        }
        if (patronRequest.sex() != null) {
            try {
                sex = ESex.valueOf(patronRequest.sex());
            } catch (IllegalArgumentException e) {
                throw new InvalidSelectOptionException();
            }
        }
        if (patronRequest.homeroom() != null) {
            try {
                homeroom = EHomeroom.valueOf(patronRequest.homeroom());
            } catch (IllegalArgumentException e) {
                throw new InvalidSelectOptionException();
            }
        }
        if (patronRequest.secondLocation() != null) {
            try {
                secondLocation = EHomeroom.valueOf(patronRequest.secondLocation());
            } catch (IllegalArgumentException e) {
                throw new InvalidSelectOptionException();
            }
        }

        return Patron.builder()
                .studentNumber(studentNumber)
                .firstName(patronRequest.firstName())
                .middleName(patronRequest.middleName())
                .lastName(patronRequest.lastName())
                .library(library)
                .status(status)
                .policy(policy)
                .birthDate(patronRequest.birthDate())
                .sex(sex)
                .homeroom(homeroom)
                .secondLocation(secondLocation)
                .graduationDate(patronRequest.graduationDate())
                .accountExpiration(patronRequest.accountExpiration())
                .primaryEmail(patronRequest.primaryEmail())
                .instituteEmail(patronRequest.instituteEmail())
                .primaryPhone(patronRequest.primaryPhone())
                .mobile(patronRequest.mobile())
                .messengers(patronRequest.messengers())
                .address1(patronRequest.address1())
                .address2(patronRequest.address2())
                .contactNotes(patronRequest.contactNotes())
                .username(patronRequest.username())
                .password(patronRequest.password())
                .generalNotes(patronRequest.generalNotes())
                .alertNotes(patronRequest.alertNotes())
                .build();
    }
}
