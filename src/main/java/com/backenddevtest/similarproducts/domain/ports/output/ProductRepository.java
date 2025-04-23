package com.backenddevtest.similarproducts.domain.ports.output;

import com.backenddevtest.similarproducts.domain.model.Product;

public interface ProductRepository {

    void save(Product product);
    
}
