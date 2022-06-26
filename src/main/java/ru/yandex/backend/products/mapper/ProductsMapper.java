package ru.yandex.backend.products.mapper;

import ru.yandex.backend.products.model.Item;
import ru.yandex.backend.products.model.dto.*;
import ru.yandex.backend.products.model.enums.ShopUnitType;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsMapper extends RootMapper {

    public Item itemFromShopUnitImport(ShopUnitImport shopUnitImport, ZonedDateTime updateTime) {
        return new Item(
                shopUnitImport.getId(),
                shopUnitImport.getName(),
                updateTime,
                shopUnitImport.getParentId(),
                shopUnitImport.getType(),
                shopUnitImport.getType()==ShopUnitType.CATEGORY? null:shopUnitImport.getPrice()
        );
    }

    public List<Item> itemsFromShopUnitImportRequest(ShopUnitImportRequest shopUnitImportRequest) {
        return shopUnitImportRequest
                .getItems()
                .stream()
                .map(v -> itemFromShopUnitImport(v, shopUnitImportRequest.getUpdateDate()))
                .collect(Collectors.toList());
    }

    public ShopUnit shopUnitFromItem(Item item) {
        formatItem(item);
        return new ShopUnit(
                item.getItemId(),
                item.getItemName(),
                formatToUTC(item.getUpdateTime()),
                item.getParentId(),
                item.getItemType(),
                item.getItemPrice(),
                shopUnitsFromItems(item.getItemType(), item.getChildrens()));
    }

    public List<ShopUnit> shopUnitsFromItems(ShopUnitType itemType, List<Item> items) {
        if(itemType == ShopUnitType.OFFER && items.isEmpty())
            return null;
        return items.stream()
                .map(this::shopUnitFromItem)
                .collect(Collectors.toList());
    }

    public Long roundPrice(Double amount) {
        BigDecimal bigDecimal = new BigDecimal(amount).setScale(0, RoundingMode.DOWN);
        return bigDecimal.longValue();
    }

    public void averagePriceCalc(Item item) {
        if(item.getItemType() == ShopUnitType.CATEGORY) {
            Double price = item.getFlatChildrens()
                    .filter(v -> v.getItemType() == ShopUnitType.OFFER)
                    .mapToLong(Item::getItemPrice)
                    .average()
                    .orElse(0.0);
            item.setItemPrice(roundPrice(price));
        }
    }

    public Item formatItem(Item item) {
        averagePriceCalc(item);
        ZonedDateTime oldestDate = item.getChildrens().stream()
                .map(this::formatItem)
                .map(Item::getUpdateTime)
                .max(ZonedDateTime::compareTo)
                .orElse(item.getUpdateTime());
        item.setUpdateTime(oldestDate);
        return item;
    }

    public ShopUnitStatisticUnit shopUnitStatisticUnitFromItem(Item item) {
        return new ShopUnitStatisticUnit(
                item.getItemId(),
                item.getItemName(),
                item.getParentId(),
                item.getItemType(),
                item.getItemPrice(),
                formatToUTC(item.getUpdateTime())
                );
     }

    public ShopUnitStatisticResponse shopUnitStatisticResponseFromItems(List<Item> items) {
        List<ShopUnitStatisticUnit> itemsRes = items.stream()
                .map(this::shopUnitStatisticUnitFromItem)
                .collect(Collectors.toList());
        return new ShopUnitStatisticResponse(itemsRes);
    }
}
