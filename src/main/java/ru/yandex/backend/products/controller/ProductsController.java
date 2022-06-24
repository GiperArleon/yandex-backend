package ru.yandex.backend.products.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.backend.products.model.dto.GeneralResponse;
import ru.yandex.backend.products.model.dto.ShopUnitImportRequest;
import ru.yandex.backend.products.service.ProductsService;
import javax.validation.Valid;

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
    public ResponseEntity<GeneralResponse> imports(@Valid @RequestBody ShopUnitImportRequest shopUnitImportRequest) {
        productsService.save(shopUnitImportRequest);
        return ResponseEntity.ok(GeneralResponse.getResponse(
                "Imports done successfully",
                HttpStatus.OK));
    }
}

