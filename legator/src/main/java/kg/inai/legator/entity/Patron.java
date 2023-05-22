package kg.inai.legator.entity;

import jakarta.persistence.*;
import kg.inai.legator.enums.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Patron {

    @Id
    String studentNumber;
    String firstName;
    String middleName;
    String lastName;
    @Enumerated(EnumType.STRING)
    ELibrary library;
    @Enumerated(EnumType.STRING)
    EPatronStatus status;
    @Enumerated(EnumType.STRING)
    EPatronPolicy policy;
    LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    ESex sex;
    @Enumerated(EnumType.STRING)
    EHomeroom homeroom;
    @Enumerated(EnumType.STRING)
    EHomeroom secondLocation;
    @ManyToOne
    @JoinColumn(name = "group_id")
    PatronGroup group;
    LocalDate graduationDate;
    LocalDate accountExpiration;
    String primaryEmail;
    String instituteEmail;
    String primaryPhone;
    String mobile;
    String messengers;
    String address1;
    String address2;
    @Column(length = 1000)
    String contactNotes;
    String username;
    String password;
    @Column(length = 5000)
    String generalNotes;
    @Column(length = 5000)
    String alertNotes;
    @OneToMany(mappedBy = "patron")
    List<Operation> operations = new ArrayList<>();
    @OneToMany(mappedBy = "patron")
    List<OperationArchive> operationArchives = new ArrayList<>();
    public void setGroup(PatronGroup group) {
        if (this.group != null) {
            this.getGroup().getPatrons().remove(this);
        }

        this.group = group;

        if (this.group != null) {
            this.group.getPatrons().add(this);
        }
    }
}
