package ru.svetlov.cloud.market.product.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.svetlov.cloud.market.product.entities.Product;
import ru.svetlov.cloud.market.product.exceptions.ResourceNotFoundException;
import ru.svetlov.cloud.market.product.services.ProductService;
import ru.svetlov.cloud.market.product.repositories.ProductRepository;
import ru.svetlov.cloud.market.services.product.common.dto.PageDto;
import ru.svetlov.cloud.market.services.product.common.dto.ProductDto;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductDto getById(Long id) {
        return productRepository.findById(id).map(this::productToDto).orElseThrow(() -> new ResourceNotFoundException("Product id: " + id + " not found."));
    }

    @Override
    public ProductDto getByTitle(String title) {
        return productRepository.findByTitle(title).map(this::productToDto).orElseThrow(() -> new ResourceNotFoundException("Product title: " + title + " not found."));
    }

    @Override
    public PageDto<ProductDto> getProductsPage(int pageSize, int pageNumber) {
        Page<ProductDto> page = productRepository.findAll(Pageable.ofSize(pageSize).withPage(pageNumber)).map(this::productToDto);
        return new PageDto<>(page);
    }

    private ProductDto productToDto(Product p) {
        return new ProductDto(p.getId(), p.getTitle(), p.getPrice());
    }
}
