package kg.inai.legator.commandLineRunner;

import jakarta.transaction.Transactional;
import kg.inai.legator.entity.Patron;
import kg.inai.legator.entity.PatronGroup;
import kg.inai.legator.repository.PatronGroupRepository;
import kg.inai.legator.repository.PatronRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class DatabaseInitializer implements CommandLineRunner {

    final PatronRepository patronRepository;
    final PatronGroupRepository patronGroupRepository;


    @Override
    public void run(String... args) throws Exception {
        PatronGroup patronGroup = new PatronGroup("patronGroup");
        patronGroup = patronGroupRepository.save(patronGroup);

        Patron patron = Patron.builder()
                .studentNumber("1")
                .firstName("firstName")
                .lastName("lastName")
                .build();
        Patron patron2 = Patron.builder()
                .studentNumber("2")
                .firstName("firstName")
                .lastName("lastName")
                .build();
        Patron patron3 = Patron.builder()
                .studentNumber("3")
                .firstName("firstName")
                .lastName("lastName")
                .build();
        patron = patronRepository.save(patron);
        patron2 = patronRepository.save(patron2);
        patron3 = patronRepository.save(patron3);

        patronGroup.addPatron(patron);
        patronGroup.addPatron(patron2);
        patronGroup.addPatron(patron3);
        patronGroupRepository.save(patronGroup);
    }
}
