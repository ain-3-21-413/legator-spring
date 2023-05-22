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
    final PatronGroupRepository patronGroupRepository;
    final BookRepository bookRepository;
    final BookFieldRepository bookFieldRepository;
    final OperationRepository operationRepository;

    private void populatePatrons() {
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
//
//    private void populateBooks() {
//        Book book = bookRepository.save(new Book());
//        BookField bookField = bookFieldRepository.save(BookField.builder().name("000-00").value("1234").build());
//        bookField
//        BookField bookField3 = bookFieldRepository.save(BookField.builder().name("100-a").value("Author").build());
//        BookField bookField4 = bookFieldRepository.save(BookField.builder().name("245-a").value("Title").build());
//    }

    @Override
    public void run(String... args) throws Exception {
//        populatePatrons();
    }
}
