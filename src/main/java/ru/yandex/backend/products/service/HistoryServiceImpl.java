package ru.yandex.backend.products.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yandex.backend.products.mapper.HistoryMapper;
import ru.yandex.backend.products.model.History;
import ru.yandex.backend.products.model.Item;
import ru.yandex.backend.products.model.dto.ShopUnitImportRequest;
import ru.yandex.backend.products.model.dto.ShopUnitStatisticResponse;
import ru.yandex.backend.products.repository.HistoryRepository;
import ru.yandex.backend.products.repository.ProductsRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class HistoryServiceImpl implements HistoryService {
    private final ProductsRepository productsRepository;
    private final HistoryRepository historyRepository;
    private final HistoryMapper historyMapper;

    @Override
    public void saveProductsHistory(ShopUnitImportRequest shopUnitImportRequest) {
        shopUnitImportRequest.getItems().forEach(v->{
            Optional<Item> item = productsRepository.findById(v.getId());
            item.ifPresent(c-> historyRepository.save(historyMapper.historyFromItem(c)));
        });
    }

    @Override
    public ShopUnitStatisticResponse getUpdatedHistory(UUID id, LocalDateTime dateStart, LocalDateTime dateEnd) {
        if(dateStart == null) {
            dateStart = LocalDateTime.of(LocalDate.EPOCH, LocalTime.MIN);
        }
        if(dateEnd == null) {
            dateEnd = LocalDateTime.now();
        }
        List<History> history = historyRepository.findHistoryByUpdateTime(id, dateStart, dateEnd);
        return historyMapper.shopUnitStatisticResponseFromHistories(history);
    }
}
