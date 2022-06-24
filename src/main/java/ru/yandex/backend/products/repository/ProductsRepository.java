package ru.yandex.backend.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.backend.products.model.Item;
import java.util.UUID;

@Repository
public interface ProductsRepository extends JpaRepository<Item, UUID> {
}
