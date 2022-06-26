package ru.yandex.backend.products.utils;

import ru.yandex.backend.products.model.dto.ShopUnit;
import ru.yandex.backend.products.model.enums.ShopUnitType;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import static ru.yandex.backend.products.utils.TestDataProvider.*;

public class ShopUnitTestData {
    public static final ShopUnit ROOT_CATEGORY = getTestShopUnit(
            uuidFromStr("069cb8d7-bbdd-47d3-ad8f-82ef4c269df1"),
            "Товары",
            ZonedDateTime.parse("2022-02-03T15:00:00.000Z[UTC]"),
            null,
            ShopUnitType.CATEGORY,
            58599L);

    public static final ShopUnit TV_CATEGORY = getTestShopUnit(
            uuidFromStr("1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2"),
            "Телевизоры",
            ZonedDateTime.parse("2022-02-03T15:00:00.000Z[UTC]"),
            UUID.nameUUIDFromBytes("069cb8d7-bbdd-47d3-ad8f-82ef4c269df1".getBytes()),
            ShopUnitType.CATEGORY,
            50999L);

    public static final ShopUnit TV_GOLDSTAR = getTestShopUnit(
            uuidFromStr("73bc3b36-02d1-4245-ab35-3106c9ee1c65"),
            "Goldstar 65\" LED UHD LOL Very Smart",
            ZonedDateTime.parse("2022-02-03T15:00:00.000Z[UTC]"),
            UUID.nameUUIDFromBytes("1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2".getBytes()),
            ShopUnitType.OFFER,
            69999L);

    public static final ShopUnit TV_PHYLLIPS = getTestShopUnit(
            uuidFromStr("74b81fda-9cdc-4b63-8927-c978afed5cf4"),
            "Phyllis 50\" LED UHD Smarter",
            ZonedDateTime.parse("2022-02-03T12:00:00.000Z[UTC]"),
            UUID.nameUUIDFromBytes("1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2".getBytes()),
            ShopUnitType.OFFER,
            49999L);

    public static final ShopUnit TV_SAMSON = getTestShopUnit(
            uuidFromStr("98883e8f-0507-482f-bce2-2fb306cf6483"),
            "Samson 70\" LED UHD Smart",
            ZonedDateTime.parse("2022-02-03T12:00:00.000Z[UTC]"),
            UUID.nameUUIDFromBytes("1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2".getBytes()),
            ShopUnitType.OFFER,
            32999L);

    public static final ShopUnit MOBILE_CATEGORY = getTestShopUnit(
            uuidFromStr("d515e43f-f3f6-4471-bb77-6b455017a2d2"),
            "Смартфоны",
            ZonedDateTime.parse("2022-02-03T12:00:00.000Z[UTC]"),
            UUID.nameUUIDFromBytes("069cb8d7-bbdd-47d3-ad8f-82ef4c269df1".getBytes()),
            ShopUnitType.CATEGORY,
            69999L);

    public static final ShopUnit JPHONE = getTestShopUnit(
            uuidFromStr("863e1a7a-1304-42ae-943b-179184c077e3"),
            "jPhone 13",
            ZonedDateTime.parse("2022-02-03T12:00:00.000Z[UTC]"),
            UUID.nameUUIDFromBytes("d515e43f-f3f6-4471-bb77-6b455017a2d2".getBytes()),
            ShopUnitType.OFFER,
            79999L);

    public static final ShopUnit XOMIA = getTestShopUnit(
            uuidFromStr("b1d8fd7d-2ae3-47d5-b2f9-0f094af800d4"),
            "Xomiа Readme 10",
            ZonedDateTime.parse("2022-02-03T12:00:00.000Z[UTC]"),
            UUID.nameUUIDFromBytes("d515e43f-f3f6-4471-bb77-6b455017a2d2".getBytes()),
            ShopUnitType.OFFER,
            59999L);

    public static final ShopUnit TVS_SHOP_UNIT = getTestShopUnit(
            TV_CATEGORY.getId(),
            TV_CATEGORY.getName(),
            TV_CATEGORY.getDate(),
            TV_CATEGORY.getParentId(),
            TV_CATEGORY.getType(),
            TV_CATEGORY.getPrice(),
            List.of(TV_GOLDSTAR, TV_PHYLLIPS, TV_SAMSON));

    public static final ShopUnit MOBILES_SHOP_UNIT = getTestShopUnit(
            MOBILE_CATEGORY.getId(),
            MOBILE_CATEGORY.getName(),
            MOBILE_CATEGORY.getDate(),
            MOBILE_CATEGORY.getParentId(),
            MOBILE_CATEGORY.getType(),
            MOBILE_CATEGORY.getPrice(),
            List.of(JPHONE, XOMIA));

    public static final ShopUnit FULL_SHOP_UNIT = getTestShopUnit(
            ROOT_CATEGORY.getId(),
            ROOT_CATEGORY.getName(),
            ROOT_CATEGORY.getDate(),
            ROOT_CATEGORY.getParentId(),
            ROOT_CATEGORY.getType(),
            ROOT_CATEGORY.getPrice(),
            List.of(TVS_SHOP_UNIT, MOBILES_SHOP_UNIT));

    public static List<ShopUnit> getFlatShopUnits() {
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
