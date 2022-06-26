package ru.yandex.backend.products.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompositeId implements Serializable {
    private UUID itemId;
    private LocalDateTime updateTime;
}
