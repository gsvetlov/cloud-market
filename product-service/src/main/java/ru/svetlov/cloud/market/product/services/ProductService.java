package ru.svetlov.cloud.market.product.services;

import org.springframework.data.domain.Page;
import ru.svetlov.cloud.market.services.product.common.dto.ProductDto;

public interface ProductService {
    ProductDto getById(Long id);
    ProductDto getByTitle(String title);
    Page<ProductDto> getProductsPage(int pageSize, int pageNumber);
}
