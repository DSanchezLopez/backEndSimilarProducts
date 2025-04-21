package com.backenddevtest.similarproducts.infraestructure.utils;

import com.backenddevtest.similarproducts.infraestructure.dto.ProductDetailsDTO;

public final class SimilarProductsUtils {

    private SimilarProductsUtils(){
        throw new UnsupportedOperationException("Utility class");
    }

    
    public static ProductDetailsDTO createFallBack() {
        ProductDetailsDTO productDetails = new ProductDetailsDTO();
        productDetails.setFallback(true);
        return productDetails;
    }

    public static boolean isFallback(ProductDetailsDTO productDetails) {
        return productDetails != null && productDetails.getFallback();
    }
    
}
