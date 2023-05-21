package kg.inai.legator.entity;

import jakarta.persistence.*;
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
public class BookField {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;

    String number;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;

    @OneToMany(mappedBy = "bookField", cascade = CascadeType.ALL, orphanRemoval = true)
    final List<BookSubfield> bookSubfields;

    public BookField() {
        this.bookSubfields = new ArrayList<>();
    }

    public void addSubfield(BookSubfield bookSubfield) {
        bookSubfields.add(bookSubfield);
        bookSubfield.setBookField(this);
    }
}
