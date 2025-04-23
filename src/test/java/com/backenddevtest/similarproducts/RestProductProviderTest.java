package com.backenddevtest.similarproducts;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import com.backenddevtest.similarproducts.domain.model.Product;
import com.backenddevtest.similarproducts.infraestructure.adapters.output.RestProductProvider;
import com.backenddevtest.similarproducts.infraestructure.dto.ProductDetailsDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class RestProductProviderTest {

    @Mock private RestTemplate restTemplate;
    private RestProductProvider provider;
    private final String PRODUCT_URL = "http://product-details/{productId}";
    private final String SIMILAR_IDS_URL = "http://similar-ids/{productId}";

    @BeforeEach
    void setUp() {
        provider = new RestProductProvider(restTemplate, PRODUCT_URL, SIMILAR_IDS_URL);
    }



    @Test
    void fetchProductDetails_WhenRestClientException_ReturnsNull() {
        String productId = "99";
        when(restTemplate.getForEntity(PRODUCT_URL, ProductDetailsDTO.class, productId))
            .thenThrow(new RestClientException("Error"));

        Product result = provider.findProductById(productId);
        assertNull(result);
    }

@Test
void findSimilarProducts_EmptySimilarIds_ReturnsEmptyList() {
    String productId = "1";
    when(restTemplate.getForEntity(SIMILAR_IDS_URL, String[].class, productId))
        .thenReturn(new ResponseEntity<>(new String[0], HttpStatus.OK));

    List<Product> products = provider.findSimilarProducts(productId);
    assertTrue(products.isEmpty());
}


}