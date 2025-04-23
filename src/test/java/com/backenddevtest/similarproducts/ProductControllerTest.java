package com.backenddevtest.similarproducts;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.backenddevtest.similarproducts.application.usecases.ProductService;
import com.backenddevtest.similarproducts.infraestructure.adapters.input.ProductController;

@SpringBootTest(classes = {ProductController.class})
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;


    @Test
    void getSimilarProducts_Returns404WhenProductNotFound() throws Exception{

        when(productService.productExists("1")).thenReturn(false);
        mockMvc.perform(get("/product/1/similar")).andExpect(status().isNotFound());

    }
    
}
