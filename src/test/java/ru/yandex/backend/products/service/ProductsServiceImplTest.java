package ru.yandex.backend.products.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.yandex.backend.products.mapper.ProductsMapper;
import ru.yandex.backend.products.model.Item;
import ru.yandex.backend.products.model.dto.ShopUnit;
import ru.yandex.backend.products.repository.ProductsRepository;
import ru.yandex.backend.products.validation.ProductValidator;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.yandex.backend.products.utils.ItemTestData.*;
import static ru.yandex.backend.products.utils.ShopUnitTestData.*;

class ProductsServiceImplTest {

    private AutoCloseable autoClosable;
    private ProductsService productsService;

    @Mock
    private ProductsRepository productsRepository;

    @BeforeEach
    void setUp() {
        autoClosable = MockitoAnnotations.openMocks(this);
        ProductValidator productValidator = new ProductValidator();
        ProductsMapper productsMapper = new ProductsMapper(productValidator);
        productsService = new ProductsServiceImpl(productsRepository, productsMapper, productValidator);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoClosable.close();
    }

    @Test
    void saveProducts() {
    }

    @ParameterizedTest(name = "test {index}: expected ShopUnit object = {1} provided Item object = {0}")
    @MethodSource("dataForTest")
    void getProductById(Item item, ShopUnit unitExpected) {
        UUID productId = UUID.randomUUID();
        BDDMockito.given(productsRepository.findById(productId)).willReturn(Optional.ofNullable(item));
        ShopUnit unitRes = productsService.getProductById(productId);
        assertThat(unitRes)
                .usingRecursiveComparison()
                .isEqualTo(unitExpected);
    }

    @Test
    void deleteProductById() {
    }

    @Test
    void findSalesByDate() {
    }

    static Stream<Arguments> dataForTest() {
        return Stream.of(
                Arguments.of(FULL_ITEM, FULL_SHOP_UNIT),
                Arguments.of(MOBILES_ITEM, MOBILES_SHOP_UNIT),
                Arguments.of(TVS_ITEM, TVS_SHOP_UNIT)
        );
    }
}