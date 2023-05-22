package kg.inai.legator.controller;

import kg.inai.legator.dto.ItemDto;
import kg.inai.legator.dto.request.ItemRequest;
import kg.inai.legator.entity.Book;
import kg.inai.legator.entity.Item;
import kg.inai.legator.entity.Patron;
import kg.inai.legator.enums.EItemStatus;
import kg.inai.legator.mapper.BookMapper;
import kg.inai.legator.mapper.ItemMapper;
import kg.inai.legator.repository.BookRepository;
import kg.inai.legator.repository.ItemRepository;
import kg.inai.legator.repository.PatronRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/items")
@RestController
public class ItemController {

    final ItemRepository itemRepository;
    final BookRepository bookRepository;
    final BookMapper bookMapper;
    final PatronRepository patronRepository;
    final ItemMapper itemMapper;

    @PostMapping
    public void addItem(@RequestBody ItemRequest itemRequest) {
        Book book = bookRepository.findById(itemRequest.bookId()).orElseThrow();
        Item item = itemRepository.save(new Item());
        item.setBook(book);
        book.getItems().add(item);
        itemRepository.save(item);
        bookRepository.save(book);
    }

    @GetMapping("/checked-out")
    public List<ItemDto> getCheckedOutItems() {
        return itemRepository.findAllByStatus(EItemStatus.CHECKED_OUT).stream().map(itemMapper::toItemDto).toList();
    }

    @GetMapping
    public List<ItemDto> getItems() {
        return itemRepository.findAll().stream().map(itemMapper::toItemDto).toList();
    }
}
