package ru.yandex.backend.products.mapper;

import ru.yandex.backend.products.model.History;
import ru.yandex.backend.products.model.Item;
import ru.yandex.backend.products.model.dto.ShopUnitStatisticResponse;
import ru.yandex.backend.products.model.dto.ShopUnitStatisticUnit;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryMapper {

    public History historyFromItem(Item item) {
        return new History(
                item.getItemId(),
                item.getItemName(),
                item.getUpdateTime(),
                item.getParentId(),
                item.getItemType(),
                item.getItemPrice()
        );
    }

    public ShopUnitStatisticUnit shopUnitStatisticUnitFromHistory(History history) {
        return new ShopUnitStatisticUnit(
                history.getItemId(),
                history.getItemName(),
                history.getParentId(),
                history.getItemType(),
                history.getItemPrice(),
                history.getUpdateTime()
        );
    }

    public ShopUnitStatisticResponse shopUnitStatisticResponseFromHistories(List<History> histories) {
        List<ShopUnitStatisticUnit> itemsRes = histories.stream()
                .map(this::shopUnitStatisticUnitFromHistory)
                .collect(Collectors.toList());
        return new ShopUnitStatisticResponse(itemsRes);
    }
}
