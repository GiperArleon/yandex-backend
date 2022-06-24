package ru.yandex.backend.products.service;

import ru.yandex.backend.products.model.dto.ShopUnitImportRequest;

public interface ProductsService {
    void save(ShopUnitImportRequest shopUnitImportRequest);
}
