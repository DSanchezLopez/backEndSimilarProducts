package com.backenddevtest.similarproducts.core.service.implemented;

import java.util.List;
import org.springframework.stereotype.Service;
import com.backenddevtest.similarproducts.core.model.Product;
import com.backenddevtest.similarproducts.core.ports.ProductProvider;
import com.backenddevtest.similarproducts.core.ports.ProductRepository;
import com.backenddevtest.similarproducts.core.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductProvider productProvider;
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductProvider productProvider, ProductRepository productRepository){
        this.productProvider = productProvider;
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getSimilarProducts(String productId) {

        log.info("Fetching similar products for ID: {}", productId);
        List<Product> products=productProvider.findSimilarProducts(productId);
        products.forEach(productRepository::save);
        return products;



    }

    @Override
    public boolean productExists(String productId) {
        log.info("Checking if product {} exist", productId);
        return productProvider.findProductById(productId)!= null;

    }



}
