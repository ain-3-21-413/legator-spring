package kg.inai.legator.controller;

import kg.inai.legator.dto.BookDto;
import kg.inai.legator.dto.ItemDto;
import kg.inai.legator.entity.Book;
import kg.inai.legator.entity.BookField;
import kg.inai.legator.mapper.BookMapper;
import kg.inai.legator.mapper.ItemMapper;
import kg.inai.legator.repository.BookFieldRepository;
import kg.inai.legator.repository.BookRepository;
import kg.inai.legator.repository.ItemRepository;
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
    final BookMapper bookMapper;
    final ItemRepository itemRepository;
    final ItemMapper itemMapper;

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
            bookField.setName(s);
            bookField.setValue((String) o);
            bookFieldRepository.save(bookField);
        });
        bookRepository.save(newBook);
    }

    @GetMapping
    public List<BookDto> getBooks() {
        return bookRepository.findAll().stream().map(bookMapper::toBookDto).toList();
    }

    @GetMapping("/{book-id}/items")
    public List<ItemDto> getItems(@PathVariable("book-id") long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        return itemRepository.findAllByBook(book).stream().map(itemMapper::toItemDto).toList();
    }
}
