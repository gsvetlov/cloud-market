package ru.svetlov.cloud.market.product.services;

import ru.svetlov.cloud.market.services.product.common.dto.PageDto;
import ru.svetlov.cloud.market.services.product.common.dto.ProductDto;

public interface ProductService {
    ProductDto getById(Long id);
    ProductDto getByTitle(String title);
    PageDto<ProductDto> getProductsPage(int pageSize, int pageNumber);
}
