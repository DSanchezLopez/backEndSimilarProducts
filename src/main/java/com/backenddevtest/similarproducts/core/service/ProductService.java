package com.backenddevtest.similarproducts.core.service;

import java.util.List;

import com.backenddevtest.similarproducts.core.model.Product;

public interface ProductService {

    List<Product> getSimilarProducts (String productId);
    boolean productExists(String productId);

}
