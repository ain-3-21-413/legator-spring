package kg.inai.legator.commandLineRunner;

import kg.inai.legator.entity.*;
import kg.inai.legator.repository.BookRepository;
import kg.inai.legator.repository.PatronGroupRepository;
import kg.inai.legator.repository.PatronRepository;
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

        BookSubfield bookSubfield1 = BookSubfield.builder().code("a").value("value1").build();
        BookSubfield bookSubfield2 = BookSubfield.builder().code("b").value("value2").build();
        BookSubfield bookSubfield3 = BookSubfield.builder().code("c").value("value3").build();
        BookSubfield bookSubfield4 = BookSubfield.builder().code("d").value("value4").build();
        BookSubfield bookSubfield5 = BookSubfield.builder().code("e").value("value5").build();

        BookField bookField1 = BookField.builder().number("000").build();
        bookField1.addSubfield(bookSubfield1);
        bookField1.addSubfield(bookSubfield2);
        bookField1.addSubfield(bookSubfield3);
        bookField1.addSubfield(bookSubfield4);
        bookField1.addSubfield(bookSubfield5);
        BookField bookField2 = BookField.builder().number("111").build();
        bookField2.addSubfield(bookSubfield1);
        bookField2.addSubfield(bookSubfield2);
        bookField2.addSubfield(bookSubfield3);
        bookField2.addSubfield(bookSubfield4);
        bookField2.addSubfield(bookSubfield5);
        BookField bookField3 = BookField.builder().number("222").build();
        bookField3.addSubfield(bookSubfield1);
        bookField3.addSubfield(bookSubfield2);
        bookField3.addSubfield(bookSubfield3);
        bookField3.addSubfield(bookSubfield4);
        bookField3.addSubfield(bookSubfield5);
        BookField bookField4 = BookField.builder().number("333").build();
        bookField4.addSubfield(bookSubfield1);
        bookField4.addSubfield(bookSubfield2);
        bookField4.addSubfield(bookSubfield3);
        bookField4.addSubfield(bookSubfield4);
        bookField4.addSubfield(bookSubfield5);
        BookField bookField5 = BookField.builder().number("444").build();
        bookField5.addSubfield(bookSubfield1);
        bookField5.addSubfield(bookSubfield2);
        bookField5.addSubfield(bookSubfield3);
        bookField5.addSubfield(bookSubfield4);
        bookField5.addSubfield(bookSubfield5);

        Book book = Book.builder().controlNumber("1").build();
        bookRepository.save(book);

        bookRepository.save(book);
    }
}
