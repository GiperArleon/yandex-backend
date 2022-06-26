package ru.yandex.backend.products.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.yandex.backend.products.model.enums.ShopUnitType;
import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "history")
@IdClass(CompositeId.class)
public class History {
    @Id
    @Column(name = "id")
    private UUID itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "update_time")
    private ZonedDateTime updateTime;

    @Column(name = "parent_id")
    private UUID parentId;

    @Column(name = "item_type")
    @Enumerated(EnumType.STRING)
    private ShopUnitType itemType;

    @Column(name = "item_price")
    private Long itemPrice;
}
