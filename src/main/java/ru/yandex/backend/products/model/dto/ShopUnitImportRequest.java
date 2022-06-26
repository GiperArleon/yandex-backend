package ru.yandex.backend.products.model.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ShopUnitImportRequest {

    private final List<ShopUnitImport> items;

    private final LocalDateTime updateDate;
}
