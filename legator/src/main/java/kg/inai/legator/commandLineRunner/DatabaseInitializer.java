package kg.inai.legator.commandLineRunner;

import kg.inai.legator.entity.Patron;
import kg.inai.legator.entity.PatronGroup;
import kg.inai.legator.repository.PatronGroupRepository;
import kg.inai.legator.repository.PatronRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
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
        patron = patronRepository.save(patron);

        patronGroup.addPatron(patron);
        patronGroupRepository.save(patronGroup);

        log.info(
                patronGroupRepository.findById("patronGroup").orElseThrow().getPatrons().toString()
        );
    }
}
