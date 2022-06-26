package ru.yandex.backend.products.service;

import ru.yandex.backend.products.model.dto.ShopUnitImportRequest;
import ru.yandex.backend.products.model.dto.ShopUnitStatisticResponse;
import java.time.ZonedDateTime;
import java.util.UUID;

public interface HistoryService {
    void saveProductsHistory(ShopUnitImportRequest shopUnitImportRequest);

    ShopUnitStatisticResponse getUpdatedHistory(UUID id, ZonedDateTime dateStart, ZonedDateTime dateEnd);
}
