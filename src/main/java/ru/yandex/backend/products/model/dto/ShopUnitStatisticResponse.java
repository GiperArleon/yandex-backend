package ru.yandex.backend.products.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class ShopUnitStatisticResponse {
    private List<ShopUnitStatisticUnit> items;
}
