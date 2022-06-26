package ru.yandex.backend.products.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.yandex.backend.products.model.enums.ShopUnitType;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ShopUnitImport {

    private final UUID id;

    private final String name;

    private final UUID parentId;

    private final ShopUnitType type;

    private final Long price;
}
