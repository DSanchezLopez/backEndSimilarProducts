package com.backenddevtest.similarproducts;

import static org.junit.jupiter.api.Assertions.*;

import com.backenddevtest.similarproducts.infraestructure.dto.ProductDetailsDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

class ProductDetailsDTOTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void serialize_IgnoresFallbackField() throws JsonProcessingException {
        ProductDetailsDTO dto = new ProductDetailsDTO();
        dto.setId("6");
        dto.setFallback(true);

        String json = mapper.writeValueAsString(dto);
        assertFalse(json.contains("fallback"));
    }
}