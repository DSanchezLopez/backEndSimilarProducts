package com.backenddevtest.similarproducts;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.backenddevtest.similarproducts.infraestructure.dto.ProductDetailsDTO;
import com.backenddevtest.similarproducts.infraestructure.utils.SimilarProductsUtils;

public class SimilarProductsUtilTest {

    @Test
    void createFallBack_ReturnsProductWithFallbackFlag(){

        ProductDetailsDTO result = SimilarProductsUtils.createFallBack();

        assertTrue(result.getFallback());
    }

    @Test 
    void isFallback_DetectsFallBaclProducts(){
        ProductDetailsDTO result = new ProductDetailsDTO();
        result.setFallback(true);

        assertTrue(SimilarProductsUtils.isFallback(result));

    }
    
}
