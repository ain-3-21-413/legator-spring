package kg.inai.legator.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@ToString
@AllArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Book {

    @Id
    String controlNumber;

    String ind1;
    
    String ind2;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    final List<BookField> bookFields;

    public Book() {
        this.bookFields = new ArrayList<>();
    }

    public void addField(BookField bookField) {
        bookFields.add(bookField);
        bookField.setBook(this);
    }
}
