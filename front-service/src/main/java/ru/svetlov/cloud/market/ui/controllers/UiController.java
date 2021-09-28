package ru.svetlov.cloud.market.ui.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.svetlov.cloud.market.ui.clients.ProductService;

@RestController
@RequiredArgsConstructor
public class UiController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<String> getRootPath() {
        return new ResponseEntity<>(productService.getInfo(), HttpStatus.OK);
    }
}
