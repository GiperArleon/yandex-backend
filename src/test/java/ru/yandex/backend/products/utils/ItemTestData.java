package ru.yandex.backend.products.utils;

import ru.yandex.backend.products.model.Item;
import ru.yandex.backend.products.model.enums.ShopUnitType;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import static ru.yandex.backend.products.utils.TestDataProvider.getTestItem;
import static ru.yandex.backend.products.utils.TestDataProvider.uuidFromStr;

public class ItemTestData {
    public static final Item ROOT_CATEGORY = getTestItem(
            uuidFromStr("069cb8d7-bbdd-47d3-ad8f-82ef4c269df1"),
            "Товары",
            ZonedDateTime.parse("2022-02-01T12:00:00.000Z"),
            null,
            ShopUnitType.CATEGORY,
            null);

    public static final Item TV_CATEGORY = getTestItem(
            uuidFromStr("1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2"),
            "Телевизоры",
            ZonedDateTime.parse("2022-02-03T15:00:00.000Z"),
            UUID.nameUUIDFromBytes("069cb8d7-bbdd-47d3-ad8f-82ef4c269df1".getBytes()),
            ShopUnitType.CATEGORY,
            null);

    public static final Item TV_GOLDSTAR = getTestItem(
            uuidFromStr("73bc3b36-02d1-4245-ab35-3106c9ee1c65"),
            "Goldstar 65\" LED UHD LOL Very Smart",
            ZonedDateTime.parse("2022-02-03T15:00:00.000Z"),
            UUID.nameUUIDFromBytes("1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2".getBytes()),
            ShopUnitType.OFFER,
            69999L);

    public static final Item TV_PHYLLIPS = getTestItem(
            uuidFromStr("74b81fda-9cdc-4b63-8927-c978afed5cf4"),
            "Phyllis 50\" LED UHD Smarter",
            ZonedDateTime.parse("2022-02-03T12:00:00.000Z"),
            UUID.nameUUIDFromBytes("1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2".getBytes()),
            ShopUnitType.OFFER,
            49999L);

    public static final Item TV_SAMSON = getTestItem(
            uuidFromStr("98883e8f-0507-482f-bce2-2fb306cf6483"),
            "Samson 70\" LED UHD Smart",
            ZonedDateTime.parse("2022-02-03T12:00:00.000Z"),
            UUID.nameUUIDFromBytes("1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2".getBytes()),
            ShopUnitType.OFFER,
            32999L);

    public static final Item MOBILE_CATEGORY = getTestItem(
            uuidFromStr("d515e43f-f3f6-4471-bb77-6b455017a2d2"),
            "Смартфоны",
            ZonedDateTime.parse("2022-02-03T12:00:00.000Z"),
            UUID.nameUUIDFromBytes("069cb8d7-bbdd-47d3-ad8f-82ef4c269df1".getBytes()),
            ShopUnitType.CATEGORY,
            null);

    public static final Item JPHONE = getTestItem(
            uuidFromStr("863e1a7a-1304-42ae-943b-179184c077e3"),
            "jPhone 13",
            ZonedDateTime.parse("2022-02-03T12:00:00.000Z"),
            UUID.nameUUIDFromBytes("d515e43f-f3f6-4471-bb77-6b455017a2d2".getBytes()),
            ShopUnitType.OFFER,
            79999L);

    public static final Item XOMIA = getTestItem(
            uuidFromStr("b1d8fd7d-2ae3-47d5-b2f9-0f094af800d4"),
            "Xomiа Readme 10",
            ZonedDateTime.parse("2022-02-03T12:00:00.000Z"),
            UUID.nameUUIDFromBytes("d515e43f-f3f6-4471-bb77-6b455017a2d2".getBytes()),
            ShopUnitType.OFFER,
            59999L);

    public static final Item TVS_ITEM = getTestItem(
            TV_CATEGORY.getItemId(),
            TV_CATEGORY.getItemName(),
            TV_CATEGORY.getUpdateTime(),
            TV_CATEGORY.getParentId(),
            TV_CATEGORY.getItemType(),
            TV_CATEGORY.getItemPrice(),
            List.of(TV_GOLDSTAR, TV_PHYLLIPS, TV_SAMSON));

    public static final Item MOBILES_ITEM = getTestItem(
            MOBILE_CATEGORY.getItemId(),
            MOBILE_CATEGORY.getItemName(),
            MOBILE_CATEGORY.getUpdateTime(),
            MOBILE_CATEGORY.getParentId(),
            MOBILE_CATEGORY.getItemType(),
            MOBILE_CATEGORY.getItemPrice(),
            List.of(JPHONE, XOMIA));

    public static final Item FULL_ITEM = getTestItem(
            ROOT_CATEGORY.getItemId(),
            ROOT_CATEGORY.getItemName(),
            ROOT_CATEGORY.getUpdateTime(),
            ROOT_CATEGORY.getParentId(),
            ROOT_CATEGORY.getItemType(),
            ROOT_CATEGORY.getItemPrice(),
            List.of(TVS_ITEM, MOBILES_ITEM));

    public static List<Item> getFlatItems() {
        return List.of(
                ROOT_CATEGORY,
                TV_CATEGORY,
                TV_GOLDSTAR,
                TV_PHYLLIPS,
                TV_SAMSON,
                JPHONE,
                XOMIA,
                MOBILE_CATEGORY
        );
    }
}
