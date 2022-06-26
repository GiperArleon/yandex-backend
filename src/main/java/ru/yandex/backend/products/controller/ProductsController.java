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
import ru.yandex.backend.products.service.HistoryService;
import ru.yandex.backend.products.service.ProductsService;
import java.time.ZonedDateTime;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class ProductsController {

    private final ProductsService productsService;
    private final HistoryService historyService;

    @GetMapping("/")
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok(GeneralResponse.getResponse(
                "Hello from products servise",
                HttpStatus.OK));
    }

    @GetMapping("/nodes/{id}")
    public ResponseEntity<ShopUnit> findProduct(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(productsService.getProductById(id));
    }

    @GetMapping("/node/{id}/statistic")
    public ResponseEntity<ShopUnitStatisticResponse> getUpdatedHistory(@PathVariable("id") UUID id,
            @RequestParam(name="dateStart", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime dateStart,
            @RequestParam(name="dateEnd", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime dateEnd) {
        return ResponseEntity.ok(historyService.getUpdatedHistory(id, dateStart, dateEnd));
    }

    @GetMapping("/sales")
    public ResponseEntity<ShopUnitStatisticResponse> findSalesByDate(@RequestParam(name="date", required = false)
                                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime date) {
        return ResponseEntity.ok(productsService.findSalesByDate(date));
    }

    @PostMapping("/imports")
    public ResponseEntity<GeneralResponse> importProducts(@RequestBody ShopUnitImportRequest shopUnitImportRequest) {
        historyService.saveProductsHistory(shopUnitImportRequest);
        productsService.saveProducts(shopUnitImportRequest);
        return ResponseEntity.ok(GeneralResponse.getResponse(
                "Imports done successfully",
                HttpStatus.OK));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GeneralResponse> deleteProduct(@PathVariable("id") UUID id) {
        productsService.deleteProductById(id);
        return ResponseEntity.ok(GeneralResponse.getResponse(
                "Delete done successfully",
                HttpStatus.OK));
    }
}

