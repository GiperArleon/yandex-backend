package ru.yandex.backend.products.mapper;

import ru.yandex.backend.products.exceptions.MappingException;
import ru.yandex.backend.products.model.Item;
import ru.yandex.backend.products.model.dto.ShopUnitImport;
import ru.yandex.backend.products.model.dto.ShopUnitImportRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsMapper {

    Item itemFromShopUnitImport(ShopUnitImport shopUnitImport, LocalDateTime updateTime) {
        return new Item(
                shopUnitImport.getId(),
                shopUnitImport.getName(),
                updateTime,
                shopUnitImport.getParentId(),
                shopUnitImport.getType(),
                shopUnitImport.getPrice()
        );
    }

    public List<Item> itemsFromShopUnitImportRequest(ShopUnitImportRequest shopUnitImportRequest) {
        return shopUnitImportRequest
                .getItems()
                .stream()
                .map(v -> itemFromShopUnitImport(v, shopUnitImportRequest.getUpdateDate()))
                .collect(Collectors.toList());
    }
}
