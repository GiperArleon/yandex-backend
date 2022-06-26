package ru.yandex.backend.products.repository;

import ru.yandex.backend.products.model.Item;
import java.time.ZonedDateTime;
import java.util.List;

public interface CriteriaQueryRepository {
    List<Item> findSalesByDate(ZonedDateTime date);
}
