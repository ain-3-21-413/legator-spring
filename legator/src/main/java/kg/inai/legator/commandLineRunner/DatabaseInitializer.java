package kg.inai.legator.commandLineRunner;

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

    }
}
