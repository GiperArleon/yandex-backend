package ru.yandex.backend.products.model;

import lombok.NoArgsConstructor;
import ru.yandex.backend.products.model.enums.ShopUnitType;
import lombok.Data;
import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Entity
@Data
@NoArgsConstructor
@Table(name = "items")
public class Item {
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

    @OneToMany(fetch = FetchType.LAZY,
               cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "parent_id",
                referencedColumnName = "id", updatable = false)
    private List<Item> childrens;

    public Item(UUID itemId, String itemName, ZonedDateTime updateTime, UUID parentId, ShopUnitType itemType, Long itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.updateTime = updateTime;
        this.parentId = parentId;
        this.itemType = itemType;
        this.itemPrice = itemPrice;
    }

    public Stream<Item> getFlatChildrens() {
        return Stream.concat(
                Stream.of(this),
                childrens.stream().flatMap(Item::getFlatChildrens));
    }
}
