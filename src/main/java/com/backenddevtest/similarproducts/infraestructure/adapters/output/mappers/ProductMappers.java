package com.backenddevtest.similarproducts.infraestructure.adapters.output.mappers;

import com.backenddevtest.similarproducts.core.model.Product;
import com.backenddevtest.similarproducts.infraestructure.documents.ProductDocument;
import com.backenddevtest.similarproducts.infraestructure.dto.ProductDetailsDTO;
import com.backenddevtest.similarproducts.infraestructure.dto.ProductResponseDTO;

public class ProductMappers {

    public static Product toDomain(ProductDetailsDTO dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setAvailability((dto.getAvailability()));
        return product;
    }

    public static ProductResponseDTO toResponse ( Product product){

        ProductResponseDTO response = new ProductResponseDTO();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setAvailability(product.getAvailability());
        return response;

        
    }

    public static ProductDocument toDocument(Product product){

        ProductDocument document = new ProductDocument();
        document.setId(product.getId());
        document.setName(product.getName());
        document.setPrice(product.getPrice());
        document.setAvailability(product.getAvailability());
        return document;
    }

    public static Product toCore (ProductDocument document){
        Product product = new Product();
        product.setId(document.getId());
        product.setName(document.getName());
        product.setPrice(document.getPrice());
        product.setAvailability(document.getAvailability());
        return product;

    }
    
}
