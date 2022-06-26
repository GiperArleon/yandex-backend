package ru.yandex.backend.products.validation;

import ru.yandex.backend.products.exceptions.ValidationException;
import ru.yandex.backend.products.model.dto.ShopUnitImportRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ProductValidator {
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE_TIME;

    public void validateShopUnitImportRequest(ShopUnitImportRequest shopUnitImportRequest) {
        if(shopUnitImportRequest == null
                || shopUnitImportRequest.getItems().isEmpty()
                || shopUnitImportRequest.getUpdateDate() == null) {
            throw new ValidationException("NotNull validation failed");
        }
        validDateTimeNew(shopUnitImportRequest.getUpdateDate().toString());
    }

    public void validDateTimeNew(String dateStr) {
        try {
            dateFormatter.parse(dateStr);
        } catch(DateTimeParseException | IllegalArgumentException ex) {
            throw new ValidationException("Date validation failed", ex.getMessage());
        }
    }
}
