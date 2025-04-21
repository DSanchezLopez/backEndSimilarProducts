package com.backenddevtest.similarproducts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.backenddevtest.similarproducts.core.model.Product;
import com.backenddevtest.similarproducts.core.ports.ProductProvider;
import com.backenddevtest.similarproducts.core.ports.ProductRepository;
import com.backenddevtest.similarproducts.core.service.implemented.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductProvider productProvider;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void getSimilarProducts_ReturnsProductsAndSavesThen(){

        String productId = "1";
        Product mockProduct = new Product();
        mockProduct.setId("2");
        when(productProvider.findSimilarProducts(productId)).thenReturn(List.of(mockProduct));

        List<Product> result = productService.getSimilarProducts(productId);

        assertEquals(1, result.size());
        assertEquals("2", result.get(0).getId());
        verify(productRepository, times(1)).save(mockProduct);
    }

    @Test
    void productExists_ReturnTrueWhenProductFound(){

        String productId = "1";
        when(productProvider.findProductById(productId)).thenReturn(new Product());

        assertTrue(productService.productExists(productId));

    }
    
}
