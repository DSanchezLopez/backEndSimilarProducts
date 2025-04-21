package com.backenddevtest.similarproducts.infraestructure.adapters.output;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.backenddevtest.similarproducts.core.model.Product;
import com.backenddevtest.similarproducts.core.ports.ProductProvider;
import com.backenddevtest.similarproducts.infraestructure.adapters.output.mappers.ProductMappers;
import com.backenddevtest.similarproducts.infraestructure.dto.ProductDetailsDTO;
import com.backenddevtest.similarproducts.infraestructure.utils.SimilarProductsUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestProductProvider implements ProductProvider{

    private final RestTemplate restTemplate;
    private final String productDetailsUrl;
    private final String similarIdsUrl;

    public RestProductProvider(RestTemplate restTemplate, String productDetailsUrl, String similarIdsUrl){

        this.restTemplate=restTemplate;
        this.productDetailsUrl=productDetailsUrl;
        this.similarIdsUrl=similarIdsUrl;

    }

    @Override
    public List<Product> findSimilarProducts(String productId) {

        log.info("Fetching similar IDs for product :{}", productId);

        List<String> similarIds =fetchSimilarIds(productId);
        return similarIds.stream()
            .map(this::fetchProductDetails)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

        // try{

        //     ResponseEntity<String[]> response = restTemplate.getForEntity(similarIdsUrl, String[].class, productId);


        //     return List.of(response.getBody());


        // }catch(HttpClientErrorException.NotFound e){
        //     log.error("Similar IDs not found por product: {}, {}",productId, e);
        //     return Collections.emptyList();

        // }catch (RestClientException e){
        //     log.error("Error fetching similar IDs por product: {},{}", productId, e);
        //     return Collections.emptyList();
        // }

    }

    @Override
    public Product findProductById(String productId) {
        return fetchProductDetails(productId);
    //    log.info("Fetching details for product: {}", productId);
    //     try{

    //         log.debug("Thread {} fetching product {}",Thread.currentThread().getName(), productId);

    //         ResponseEntity<ProductDetailsDTO> response = restTemplate.getForEntity(productDetailsUrl, ProductDetailsDTO.class, productId);
    //         ProductDetailsDTO dto = response.getBody();

    //         if(dto == null || SimilarProductsUtils.isFallback(dto)){
    //             log.warn("Fallback triggered for product: {}", productId);
    //             return null;
    //         }
    //         return ProductMappers.toDomain(dto);



    //     }catch(RestClientException e){
    //         log.error("Error fetching details for product: {} , {}",productId, e);
        
    //         return null; 
    //     }
    }


    private List<String> fetchSimilarIds(String productId){
        try{
            ResponseEntity<String[]> response = restTemplate.getForEntity(similarIdsUrl, String[].class, productId);

            return List.of(Objects.requireNonNull(response.getBody()));
        }catch(RestClientException e){

            log.error("Error fetching similar IDs por product: {},{}", productId, e);
            return Collections.emptyList();

        }
    }
    
    private Product fetchProductDetails(String productId){

        log.info("Fetching details for product: {}", productId);
        try{

            ResponseEntity<ProductDetailsDTO> response = restTemplate.getForEntity(productDetailsUrl, ProductDetailsDTO.class, productId);
            ProductDetailsDTO dto = response.getBody();

            return(dto != null && !SimilarProductsUtils.isFallback(dto)) ? ProductMappers.toDomain(dto) :null;


        }catch(RestClientException e){
            log.error("Error fetching details for product: {} , {}",productId, e);
            return null; 
        }
    }
    
}
