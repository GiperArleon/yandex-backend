package ru.yandex.backend.products.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yandex.backend.products.mapper.HistoryMapper;
import ru.yandex.backend.products.mapper.ProductsMapper;
import ru.yandex.backend.products.model.History;
import ru.yandex.backend.products.model.Item;
import ru.yandex.backend.products.model.dto.ShopUnitImportRequest;
import ru.yandex.backend.products.model.dto.ShopUnitStatisticResponse;
import ru.yandex.backend.products.repository.HistoryRepository;
import ru.yandex.backend.products.repository.ProductsRepository;
import java.time.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class HistoryServiceImpl implements HistoryService {
    private final ProductsRepository productsRepository;
    private final HistoryRepository historyRepository;
    private final HistoryMapper historyMapper;
    private final ProductsMapper productsMapper;

    @Override
    public void saveProductsHistory(ShopUnitImportRequest shopUnitImportRequest) {
        shopUnitImportRequest.getItems().forEach(v->{
            Optional<Item> item = productsRepository.findById(v.getId());
            item.ifPresent(c-> {
                if(c.getItemPrice()==null) {
                    c.setItemPrice(calcCategoryPrice(c));
                }
                historyRepository.save(historyMapper.historyFromItem(c));
            });
        });
    }

    private Long calcCategoryPrice(Item item) {
        return productsMapper.shopUnitFromItem(item).getPrice();
    }

    @Override
    public ShopUnitStatisticResponse getUpdatedHistory(UUID id, ZonedDateTime dateStart, ZonedDateTime dateEnd) {
        List<History> history;
        if(dateStart == null || dateEnd == null) {
           history = historyRepository.findFullHistory(id);
        } else {
           history = historyRepository.findHistoryByUpdateTime(id, dateStart, dateEnd);
        }
        return historyMapper.shopUnitStatisticResponseFromHistories(history);
    }
}

