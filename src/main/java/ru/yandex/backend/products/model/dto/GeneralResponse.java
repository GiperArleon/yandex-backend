package ru.yandex.backend.products.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralResponse {

    protected int code;

    protected String message;

    protected HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    protected LocalDateTime timeStamp;

    public static GeneralResponse getResponse(String message, HttpStatus status) {
        return GeneralResponse.builder()
                .timeStamp(LocalDateTime.now())
                .message(message)
                .status(status)
                .code(status.value())
                .build();
    }
}
