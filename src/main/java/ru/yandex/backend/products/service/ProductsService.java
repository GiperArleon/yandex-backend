package ru.yandex.backend.products.service;

import ru.yandex.backend.products.model.dto.ShopUnit;
import ru.yandex.backend.products.model.dto.ShopUnitImportRequest;

import java.util.UUID;

public interface ProductsService {
    void saveProducts(ShopUnitImportRequest shopUnitImportRequest);

    ShopUnit getProductById(UUID id);

    void deleteProductById(UUID id);
}
