package ru.svetlov.cloud.market.product.services.impl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.svetlov.cloud.market.product.entities.Product;
import ru.svetlov.cloud.market.product.exceptions.ResourceNotFoundException;
import ru.svetlov.cloud.market.product.repositories.ProductRepository;
import ru.svetlov.cloud.market.product.services.ProductService;
import ru.svetlov.cloud.market.services.product.common.dto.ProductDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository repo;

    private ProductService service;

    @BeforeEach
    void setUp() {
        service = new ProductServiceImpl(repo);
    }

    @ParameterizedTest
    @DisplayName("getById throws on invalid ids")
    @ValueSource(longs = {0, -1})
    void getById_withNonValidId_Throws(Long nonValid) {
        assertThrows(
                ResourceNotFoundException.class,
                () -> service.getById(nonValid));
    }

    @Test
    @DisplayName("getById throws when not found or null Id")
    void getById_notExistentId_Throws() {
        assertThrows(ResourceNotFoundException.class,
                () -> service.getById(100L));
        assertThrows(ResourceNotFoundException.class,
                () -> service.getById(null));
    }

    @Test
    @DisplayName("getByTitle returns correct ProductDto")
    void getByTitle_withExistingTitle_returnsValidDto() {
        when(repo.findByTitle("Item-1")).thenReturn(Optional.of(
                        new Product(100L, "Item-1", BigDecimal.TEN, LocalDateTime.now(), LocalDateTime.now())));

        ProductDto expected = new ProductDto(100L, "Item-1", BigDecimal.TEN);
        ProductDto actual = service.getByTitle("Item-1");

        assertEquals(expected, actual);
    }

    @Test
    @Disabled("not implemented")
    void getProductsPage() {
        fail();
    }
}