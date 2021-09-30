package ru.svetlov.cloud.market.product.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.svetlov.cloud.market.product.services.ProductService;
import ru.svetlov.cloud.market.services.product.common.dto.PageDto;
import ru.svetlov.cloud.market.services.product.common.dto.ProductDto;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<ProductDto> getByTitle(@PathVariable(name = "title") String title) {
        return new ResponseEntity<>(productService.getByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<PageDto<ProductDto>> getProductsPage(
            @RequestParam(name = "ps", defaultValue = "10") int pageSize,
            @RequestParam(name = "p", defaultValue = "0") int pageNumber) {
        return new ResponseEntity<>(productService.getProductsPage(pageSize, pageNumber),  HttpStatus.OK);
    }


}
