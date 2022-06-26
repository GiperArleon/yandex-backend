package ru.yandex.backend.products.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.yandex.backend.products.mapper.HistoryMapper;
import ru.yandex.backend.products.mapper.ProductsMapper;
import ru.yandex.backend.products.validation.ProductValidator;

@Configuration
public class UtiliteBeansConfig {

    @Bean
    ProductsMapper productsMapper() {
        return new ProductsMapper(productValidator());
    }

    @Bean
    HistoryMapper historyMapper() {
        return new HistoryMapper();
    }

    @Bean
    ProductValidator productValidator() {
        return new ProductValidator();
    }
}
