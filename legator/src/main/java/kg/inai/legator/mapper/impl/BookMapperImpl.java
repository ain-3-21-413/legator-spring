package kg.inai.legator.mapper.impl;

import kg.inai.legator.dto.BookDto;
import kg.inai.legator.entity.Book;
import kg.inai.legator.mapper.BookMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements BookMapper {
    @Override
    public BookDto toBookDto(Book book) {
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
}
