package ru.yandex.backend.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.yandex.backend.products.model.Item;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProductsRepository extends JpaRepository<Item, UUID>, CriteriaQueryRepository {
    @Query(value = "select id, item_name, update_time, parent_id, item_type, item_price " +
                    "from items v " +
                    "where v.item_type = 'OFFER'" +
                    "and v.update_time >= :from " +
                    "and v.update_time <= :to",
            nativeQuery = true)
    List<Item> findSalesByUpdateTime(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);
}
