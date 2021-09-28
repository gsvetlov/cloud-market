package ru.svetlov.cloud.market.product.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {
    @GetMapping("/info")
    public ResponseEntity<String> getInfo() {
        return new ResponseEntity<>("this is a product controller", HttpStatus.OK);
    }
}
