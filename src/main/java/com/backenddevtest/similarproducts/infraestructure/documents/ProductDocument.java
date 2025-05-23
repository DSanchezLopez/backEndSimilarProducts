package com.backenddevtest.similarproducts.infraestructure.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "products")
public class ProductDocument {
    
    @Id
    private String id;
    private String name;
    private Double price;
    private Boolean availability;

    
}
