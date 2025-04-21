package com.backenddevtest.similarproducts.infraestructure.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

import com.backenddevtest.similarproducts.infraestructure.adapters.output.RestProductProvider;

@Configuration
@EnableMongoRepositories(basePackages = "com.backenddevtest.similarproducts.infraestructure.adapters.output")
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RestProductProvider productProvider(
        RestTemplate restTemplate,
        @Value("${product-service.product-details-url}") String detailsUrl,
        @Value("${product-service.product-similar-url}") String similarUrl){

        
        return new RestProductProvider(restTemplate, detailsUrl, similarUrl);

    }

}
   
