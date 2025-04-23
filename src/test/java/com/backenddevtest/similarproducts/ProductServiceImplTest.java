package com.backenddevtest.similarproducts;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.backenddevtest.similarproducts.application.usecases.implemented.ProductServiceImpl;
import com.backenddevtest.similarproducts.domain.model.Product;
import com.backenddevtest.similarproducts.domain.ports.output.ProductProvider;
import com.backenddevtest.similarproducts.domain.ports.output.ProductRepository;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock private ProductProvider productProvider;
    @Mock private ProductRepository productRepository;
    @InjectMocks private ProductServiceImpl productService;

    @Test
    void getSimilarProducts_ValidId_SavesProducts() {
        Product product = new Product();
        product.setId("1");
        when(productProvider.findSimilarProducts("1")).thenReturn(List.of(product));

        List<Product> result = productService.getSimilarProducts("1");
        verify(productRepository, times(1)).save(product);
        assertEquals(1, result.size());
    }

    @Test
    void productExists_WhenProductFound_ReturnsTrue() {
        when(productProvider.findProductById("1")).thenReturn(new Product());
        assertTrue(productService.productExists("1"));
    }

@Test
void getSimilarProducts_EmptyResponse_ReturnsEmptyList() {
    when(productProvider.findSimilarProducts("2")).thenReturn(Collections.emptyList());
    
    List<Product> result = productService.getSimilarProducts("2");
    assertTrue(result.isEmpty());
    verify(productRepository, never()).save(any());
}

@Test
void productExists_WhenProductNotFound_ReturnsFalse() {
    when(productProvider.findProductById("3")).thenReturn(null);
    assertFalse(productService.productExists("3"));
}
}