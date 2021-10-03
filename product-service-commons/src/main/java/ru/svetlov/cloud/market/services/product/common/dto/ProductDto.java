package ru.svetlov.cloud.market.services.product.common.dto;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ProductDto {
    private Long id;
    private String title;
    private BigDecimal price;
}
