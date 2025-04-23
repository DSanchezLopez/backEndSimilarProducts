package com.backenddevtest.similarproducts;

import static org.junit.jupiter.api.Assertions.*;

import com.backenddevtest.similarproducts.domain.mappers.ProductMappers;
import com.backenddevtest.similarproducts.domain.model.Product;
import com.backenddevtest.similarproducts.infraestructure.documents.ProductDocument;
import com.backenddevtest.similarproducts.infraestructure.dto.ProductDetailsDTO;
import com.backenddevtest.similarproducts.infraestructure.dto.ProductResponseDTO;
import org.junit.jupiter.api.Test;

class ProductMappersTest {

    @Test
    void toDomain_FromProductDetailsDTO_FieldsMappedCorrectly() {
        ProductDetailsDTO dto = new ProductDetailsDTO();
        dto.setId("1");
        dto.setName("Product");
        dto.setPrice(100.0);
        dto.setAvailability(true);

        Product product = ProductMappers.toDomain(dto);

        assertEquals(dto.getId(), product.getId());
        assertEquals(dto.getName(), product.getName());
        assertEquals(dto.getPrice(), product.getPrice());
        assertEquals(dto.getAvailability(), product.getAvailability());
    }

    @Test
    void toResponse_FromProduct_FieldsMappedCorrectly() {
        Product product = new Product();
        product.setId("2");
        product.setName("Another Product");
        product.setPrice(200.0);
        product.setAvailability(false);

        ProductResponseDTO response = ProductMappers.toResponse(product);

        assertEquals(product.getId(), response.getId());
        assertEquals(product.getName(), response.getName());
        assertEquals(product.getPrice(), response.getPrice());
        assertEquals(product.getAvailability(), response.getAvailability());
    }



@Test
void toDocument_FromProduct_FieldsMappedCorrectly() {
    Product product = new Product();
    product.setId("3");
    product.setName("Mapped Product");
    product.setPrice(150.0);
    product.setAvailability(true);

    ProductDocument document = ProductMappers.toDocument(product);

    assertEquals(product.getId(), document.getId());
    assertEquals(product.getName(), document.getName());
    assertEquals(product.getPrice(), document.getPrice());
    assertEquals(product.getAvailability(), document.getAvailability());
}

@Test
void toCore_FromProductDocument_FieldsMappedCorrectly() {
    ProductDocument document = new ProductDocument();
    document.setId("4");
    document.setName("Core Product");
    document.setPrice(300.0);
    document.setAvailability(false);

    Product product = ProductMappers.toCore(document);

    assertEquals(document.getId(), product.getId());
    assertEquals(document.getName(), product.getName());
    assertEquals(document.getPrice(), product.getPrice());
    assertEquals(document.getAvailability(), product.getAvailability());
}
}