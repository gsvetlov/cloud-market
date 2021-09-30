package ru.svetlov.cloud.market.ui.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.svetlov.cloud.market.services.product.common.dto.PageDto;
import ru.svetlov.cloud.market.services.product.common.dto.ProductDto;
import ru.svetlov.cloud.market.ui.clients.ProductService;

@RestController
@RequiredArgsConstructor
public class UiController {
    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<PageDto<ProductDto>> getProducts(
            @RequestParam(name = "ps", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "p", defaultValue = "0") Integer pageNumber) {
        return new ResponseEntity<>(productService.getProductsPage(pageSize, pageNumber), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable(name = "id")Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping("/products/title/{title}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable(name = "title")String title) {
        return new ResponseEntity<>(productService.getProductByTitle(title), HttpStatus.OK);
    }
}
