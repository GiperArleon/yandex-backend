package ru.yandex.backend.products.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Wrong validation")
public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
        log.error("Ex: {} ", message);
    }
}
