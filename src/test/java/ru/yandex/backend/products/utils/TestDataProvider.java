package ru.yandex.backend.products.utils;

import ru.yandex.backend.products.model.Item;
import ru.yandex.backend.products.model.dto.ShopUnit;
import ru.yandex.backend.products.model.enums.ShopUnitType;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestDataProvider {

     public static UUID uuidFromStr(String value) {
        return UUID.nameUUIDFromBytes(value.getBytes());
    }

    public static Item getTestItem(UUID itemId,
                String itemName,
                ZonedDateTime updateTime,
                UUID parentId,
                ShopUnitType itemType,
                Long itemPrice) {
        return new Item(
                itemId == null ? UUID.randomUUID() : itemId,
                itemName,
                updateTime,
                parentId,
                itemType,
                itemPrice,
                new ArrayList<>()
        );
    }

    public static Item getTestItem(UUID itemId,
                String itemName,
                ZonedDateTime updateTime,
                UUID parentId,
                ShopUnitType itemType,
                Long itemPrice,
                List<Item> childrens) {
        return new Item(
                itemId == null ? UUID.randomUUID() : itemId,
                itemName,
                updateTime,
                parentId,
                itemType,
                itemPrice,
                childrens
        );
    }

    public static ShopUnit getTestShopUnit(UUID itemId,
                String itemName,
                ZonedDateTime updateTime,
                UUID parentId,
                ShopUnitType itemType,
                Long itemPrice) {
        return new ShopUnit(
                itemId,
                itemName,
                updateTime,
                parentId,
                itemType,
                itemPrice);
    }

    public static ShopUnit getTestShopUnit(
                UUID itemId,
                String itemName,
                ZonedDateTime updateTime,
                UUID parentId,
                ShopUnitType itemType,
                Long itemPrice,
                List<ShopUnit> children) {
        return new ShopUnit(
                itemId,
                itemName,
                updateTime,
                parentId,
                itemType,
                itemPrice,
                children);
    }
}
