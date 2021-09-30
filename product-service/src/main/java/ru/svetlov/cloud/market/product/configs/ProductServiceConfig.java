package ru.svetlov.cloud.market.product.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.svetlov.cloud.market.product.repositories.ProductRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = {ProductRepository.class})
public class ProductServiceConfig {
}
