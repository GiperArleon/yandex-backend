package ru.yandex.backend.products.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yandex.backend.products.exceptions.ObjectNotFoundException;
import ru.yandex.backend.products.mapper.ProductsMapper;
import ru.yandex.backend.products.model.Item;
import ru.yandex.backend.products.model.dto.ShopUnit;
import ru.yandex.backend.products.model.dto.ShopUnitImportRequest;
import ru.yandex.backend.products.repository.ProductsRepository;
import ru.yandex.backend.products.validation.ProductValidator;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;
    private final ProductsMapper productsMapper;
    private final ProductValidator productValidator;

    @Override
    public void saveProducts(ShopUnitImportRequest shopUnitImportRequest) {
        productValidator.validateShopUnitImportRequest(shopUnitImportRequest);
        productsMapper.itemsFromShopUnitImportRequest(shopUnitImportRequest)
                      .forEach(productsRepository::save);
    }

    @Override
    public ShopUnit getProductById(UUID id) {
        Item item = productsRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Item " + id + " not found"));
        return productsMapper.shopUnitFromItem(item);
    }

    @Override
    public void deleteProductById(UUID id) {
        getProductById(id);
        productsRepository.deleteById(id);
    }
}
