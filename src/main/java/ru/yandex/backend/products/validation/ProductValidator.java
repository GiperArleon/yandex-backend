package ru.yandex.backend.products.validation;

import ru.yandex.backend.products.exceptions.ValidationException;
import ru.yandex.backend.products.model.dto.ShopUnitImportRequest;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ProductValidator {
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE_TIME; //ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);  DateTimeFormatter.ISO_INSTANT  ISO_DATE_TIME

    public void validateShopUnitImportRequest(ShopUnitImportRequest shopUnitImportRequest) {
        if(shopUnitImportRequest == null
        || shopUnitImportRequest.getItems().isEmpty()
        || shopUnitImportRequest.getUpdateDate() == null
        ) {
            throw new ValidationException("NotNull validation failed");
        }
        validDateTime(shopUnitImportRequest.getUpdateDate().toString());
    }

    public void validDateTime(String dateStr) {
        try {
            this.dateFormatter.parse(dateStr);
        } catch (DateTimeParseException e) {
            throw new ValidationException("Invalid date");
        }
    }
}
