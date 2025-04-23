package com.backenddevtest.similarproducts.domain.ports.output;

import java.util.List;

import com.backenddevtest.similarproducts.domain.model.Product;

public interface ProductProvider {

List<Product> findSimilarProducts (String productId);
Product findProductById(String productId);
    
}
