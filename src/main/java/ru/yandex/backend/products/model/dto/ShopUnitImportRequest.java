package ru.yandex.backend.products.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ShopUnitImportRequest {

    private List<ShopUnitImport> items;

    private ZonedDateTime updateDate;
}
