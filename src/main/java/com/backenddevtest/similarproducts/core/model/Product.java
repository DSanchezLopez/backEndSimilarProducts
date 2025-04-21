package com.backenddevtest.similarproducts.core.model;

import lombok.Data;

@Data
public class Product {

    private String id;
    private String name;
    private Double price;
    private Boolean availability;
    
}
