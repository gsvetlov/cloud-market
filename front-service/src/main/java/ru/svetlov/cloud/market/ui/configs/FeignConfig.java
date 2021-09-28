package ru.svetlov.cloud.market.ui.configs;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEurekaClient
@EnableFeignClients(basePackages = "ru.svetlov.cloud.market.ui.clients")
public class FeignConfig {
}
