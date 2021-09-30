package ru.svetlov.cloud.market.ui.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.svetlov.cloud.market.services.product.common.dto.PageDto;
import ru.svetlov.cloud.market.services.product.common.dto.ProductDto;

@FeignClient("cloud-market.product-service")
public interface ProductService {
    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    ProductDto getProductById(@PathVariable(name = "id") Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/products/title/{title}")
    ProductDto getProductByTitle(@PathVariable(name = "title") String title);

    @RequestMapping(method = RequestMethod.GET, value = "/products/page")
    PageDto<ProductDto> getProductsPage(@RequestParam(name = "ps") Integer pageSize,
                                        @RequestParam(name = "p") Integer pageNumber);
}
