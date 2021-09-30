package ru.svetlov.cloud.market.services.product.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageDto<T> {
    private long totalElements;
    private List<T> content;
    private long totalPages;
    private int number;
    private int numberOfElements;
    private int size;

    public PageDto(Page<T> page){
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.content = page.getContent();
        this.number = page.getNumber();
        this.numberOfElements = page.getNumberOfElements();
        this.size = page.getSize();
    }

}
