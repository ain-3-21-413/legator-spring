package kg.inai.legator.mapper;

import kg.inai.legator.dto.ItemDto;
import kg.inai.legator.entity.Item;
import kg.inai.legator.entity.OperationArchive;

public interface ItemMapper {

    ItemDto toItemDto(Item item);

    ItemDto toItemDto(OperationArchive operationArchive);
}
