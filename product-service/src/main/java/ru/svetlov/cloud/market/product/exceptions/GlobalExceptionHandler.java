package ru.svetlov.cloud.market.product.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.svetlov.cloud.market.services.product.common.dto.ApiErrorDto;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiErrorDto> getResourceNotFoundExceptionResponse(ResourceNotFoundException e) {
        return new ResponseEntity<>(new ApiErrorDto(e.getMessage(), LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ApiErrorDto> getBadRequestException(IllegalArgumentException e) {
        return new ResponseEntity<>(new ApiErrorDto(e.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }
}
