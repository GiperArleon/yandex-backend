package ru.yandex.backend.products.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.yandex.backend.products.model.enums.ShopUnitType;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ShopUnit {
    private UUID id;

    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private ZonedDateTime date;

    private UUID parentId;

    private ShopUnitType type;

    private Long price;

    private List<ShopUnit> children;
}
