package ru.svetlov.cloud.market.ui.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("cloud-market.product-service")
public interface ProductService {
    @RequestMapping(method = RequestMethod.GET, value = "/products/info")
    String getInfo();
}
