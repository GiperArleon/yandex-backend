package ru.yandex.backend.products.model.dto;

import lombok.Data;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class ShopUnitImportRequest {

    private final List<ShopUnitImport> items;

    private final ZonedDateTime updateDate;
}
