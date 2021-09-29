package ru.svetlov.cloud.market.services.product.common.dto;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class ApiErrorDto {
    private final String message;
    private final LocalDateTime timestamp;
}
