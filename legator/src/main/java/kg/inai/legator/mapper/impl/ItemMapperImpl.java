package kg.inai.legator.mapper.impl;

import kg.inai.legator.dto.ItemDto;
import kg.inai.legator.entity.Item;
import kg.inai.legator.entity.OperationArchive;
import kg.inai.legator.enums.EItemStatus;
import kg.inai.legator.mapper.BookMapper;
import kg.inai.legator.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ItemMapperImpl implements ItemMapper {

    final BookMapper bookMapper;

    @Override
    public ItemDto toItemDto(Item item) {
        return new ItemDto(
                item.getId(),
                bookMapper.toBookDto(item.getBook()),
                item.getOperation() == null ? null : item.getOperation().getIssuedAt(),
                item.getOperation() == null ? null : item.getOperation().getDueTo(),
                null,
                item.getStatus().name()
        );
    }

    @Override
    public ItemDto toItemDto(OperationArchive operationArchive) {
        return new ItemDto(
                operationArchive.getItem().getId(),
                bookMapper.toBookDto(operationArchive.getItem().getBook()),
                operationArchive.getIssuedAt(),
                operationArchive.getDueTo(),
                operationArchive.getReturnDate(),
                EItemStatus.CHECKED_OUT.name()
        );
    }
}
