package ru.yandex.backend.products.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.yandex.backend.products.model.enums.ShopUnitType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ShopUnitImport {
    @NotNull
    private final UUID id;

    @NotNull
    @Size(min = 1, max=100, message="name must from 1 to 100 characters long")
    private final String name;

    private final UUID parentId;

    @NotNull
    private final ShopUnitType type;

    private final Long price;
}
