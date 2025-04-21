package com.backenddevtest.similarproducts.core.ports;

import java.util.List;

import com.backenddevtest.similarproducts.core.model.Product;

public interface ProductProvider {

List<Product> findSimilarProducts (String productId);
Product findProductById(String productId);
    
}
