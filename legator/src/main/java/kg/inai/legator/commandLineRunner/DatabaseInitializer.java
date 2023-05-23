package kg.inai.legator.commandLineRunner;

import kg.inai.legator.entity.*;
import kg.inai.legator.repository.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class DatabaseInitializer implements CommandLineRunner {

    final PatronRepository patronRepository;
    final BookRepository bookRepository;
    final BookFieldRepository bookFieldRepository;
    final OperationRepository operationRepository;

    @Override
    public void run(String... args) throws Exception {
//        populatePatrons();
    }
}
