package kg.inai.legator.dto.request;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PatronRequest(
        String firstName,
        String middleName,
        String lastName,
        String library,
        String status,
        String policy,
        LocalDate birthDate,
        String sex,
        String homeroom,
        String secondLocation,
        String group,
        LocalDate graduationDate,
        LocalDate accountExpiration,
        String primaryEmail,
        String instituteEmail,
        String primaryPhone,
        String mobile,
        String messengers,
        String address1,
        String address2,
        String contactNotes,
        String username,
        String password,
        String confirmPassword,
        String generalNotes,
        String alertNotes
) {
}
