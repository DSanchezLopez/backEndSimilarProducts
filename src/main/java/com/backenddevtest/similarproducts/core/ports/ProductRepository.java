package com.backenddevtest.similarproducts.core.ports;

import com.backenddevtest.similarproducts.core.model.Product;

public interface ProductRepository {

    void save(Product product);
    
}
