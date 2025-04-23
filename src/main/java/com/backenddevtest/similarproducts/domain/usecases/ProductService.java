package com.backenddevtest.similarproducts.domain.usecases;

import java.util.List;

import com.backenddevtest.similarproducts.domain.model.Product;

public interface ProductService {

    List<Product> getSimilarProducts (String productId);
    boolean productExists(String productId);

}
