package ru.yandex.backend.products.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yandex.backend.products.mapper.ProductsMapper;
import ru.yandex.backend.products.model.dto.ShopUnitImportRequest;
import ru.yandex.backend.products.repository.ProductsRepository;
import ru.yandex.backend.products.validation.ProductValidator;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;
    private final ProductsMapper productsMapper;
    private final ProductValidator productValidator;

    @Override
    public void save(ShopUnitImportRequest shopUnitImportRequest) {
        productValidator.validateShopUnitImportRequest(shopUnitImportRequest);
        productsMapper
                .itemsFromShopUnitImportRequest(shopUnitImportRequest)
                .forEach(productsRepository::save);
    }
}
