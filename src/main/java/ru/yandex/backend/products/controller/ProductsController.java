package ru.yandex.backend.products.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.backend.products.model.dto.GeneralResponse;
import ru.yandex.backend.products.model.dto.ShopUnit;
import ru.yandex.backend.products.model.dto.ShopUnitImportRequest;
import ru.yandex.backend.products.service.ProductsService;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping("/")
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok(GeneralResponse.getResponse(
                "Hello from products servise",
                HttpStatus.OK));
    }

    @PostMapping("/imports")
    public ResponseEntity<GeneralResponse> importProducts(@Valid @RequestBody ShopUnitImportRequest shopUnitImportRequest) {
        productsService.saveProducts(shopUnitImportRequest);
        return ResponseEntity.ok(GeneralResponse.getResponse(
                "Imports done successfully",
                HttpStatus.OK));
    }

    @GetMapping("/nodes/{id}")
    public ResponseEntity<ShopUnit> findProduct(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(productsService.getProductById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GeneralResponse> deleteProduct(@PathVariable("id") UUID id) {
        productsService.deleteProductById(id);
        return ResponseEntity.ok(GeneralResponse.getResponse(
                "Delete done successfully",
                HttpStatus.OK));
    }
}

