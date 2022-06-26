package ru.yandex.backend.products.validation;

import ru.yandex.backend.products.exceptions.ValidationException;
import ru.yandex.backend.products.model.dto.ShopUnitImport;
import ru.yandex.backend.products.model.dto.ShopUnitImportRequest;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ProductValidator {
    private static final int NAME_MAX_SIZE = 100;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;

    public void validateNotNull(Object object) {
        if(object == null) {
            throw new ValidationException("NotNull validation failed");
        }
    }

    public void validateShopUnitImportRequest(ShopUnitImportRequest shopUnitImportRequest) {
        if(shopUnitImportRequest == null
                || shopUnitImportRequest.getItems().isEmpty()
                || shopUnitImportRequest.getUpdateDate() == null) {
            throw new ValidationException("NotNull validation failed");
        }
        validDateTimeNew(shopUnitImportRequest.getUpdateDate().toString());
    }

    public void validateShopUnitImport(ShopUnitImport shopUnitImport) {
        if(shopUnitImport == null
                || shopUnitImport.getId() == null
                || shopUnitImport.getName() == null
                || shopUnitImport.getType() == null) {
            throw new ValidationException("NotNull validation failed");
        }
        validateShopUnitImportNameSize(shopUnitImport.getName());
    }

    public void validateShopUnitImportNameSize(String name) {
        if(name.isEmpty()
                || name.length() > NAME_MAX_SIZE) {
            throw new ValidationException("name should be from 1 to 100 characters long");
        }
    }

    public void validDateTimeNew(String dateStr) {
        try {
            dateFormatter.parse(dateStr);
        } catch(DateTimeParseException | IllegalArgumentException ex) {
            throw new ValidationException("Date validation failed", ex.getMessage());
        }
    }
}
