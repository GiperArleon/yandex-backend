package ru.yandex.backend.products.controller;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.backend.products.model.dto.GeneralResponse;
import ru.yandex.backend.products.model.dto.ShopUnit;
import ru.yandex.backend.products.model.dto.ShopUnitImportRequest;
import ru.yandex.backend.products.model.dto.ShopUnitStatisticResponse;
import ru.yandex.backend.products.service.ProductsService;

import java.time.LocalDateTime;
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
    public ResponseEntity<GeneralResponse> importProducts(@RequestBody ShopUnitImportRequest shopUnitImportRequest) {
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

    @GetMapping("/sales")
    public ResponseEntity<ShopUnitStatisticResponse> findSalesByDate(@RequestParam(required = false)
                                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                                     LocalDateTime date) {
        return ResponseEntity.ok(productsService.findSalesByDate(date));
    }
}

