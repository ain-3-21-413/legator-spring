package kg.inai.legator.mapper;

import kg.inai.legator.dto.BookDto;
import kg.inai.legator.entity.Book;

public interface BookMapper {

    BookDto toBookDto(Book book);
}
