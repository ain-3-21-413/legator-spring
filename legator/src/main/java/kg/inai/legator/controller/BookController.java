package kg.inai.legator.controller;

import kg.inai.legator.dto.BookDto;
import kg.inai.legator.entity.Book;
import kg.inai.legator.entity.BookField;
import kg.inai.legator.repository.BookFieldRepository;
import kg.inai.legator.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/books")
@RestController
public class BookController {

    final BookFieldRepository bookFieldRepository;
    final BookRepository bookRepository;

    @PostMapping
    public void addBook(@RequestBody Map<String, Object> book) {
        Book newBook = bookRepository.save(Book.builder().build());
        book.forEach((s, o) -> {
            BookField bookField = BookField.builder().name(s).value((String) o).build();
            bookField.setBook(newBook);
            bookFieldRepository.save(bookField);
        });
        bookRepository.save(newBook);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable long id, @RequestBody Map<String, Object> book) {
        Book newBook = bookRepository.findById(id).orElseThrow();
        book.forEach((s, o) -> {
            BookField bookField = bookFieldRepository.findByNameAndBook(s, newBook).orElseThrow();
            bookField.setBook(newBook);
            bookFieldRepository.save(bookField);
        });
        bookRepository.save(newBook);
    }

    private BookDto mapToDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getBookFields().stream().map(bookField -> {
                    return new BookDto.BookFieldDto(
                            bookField.getName(),
                            bookField.getValue()
                    );
                }).toList()
        );
    }

    @GetMapping
    public List<BookDto> getBooks() {
        return bookRepository.findAll().stream().map(this::mapToDto).toList();
    }
}
