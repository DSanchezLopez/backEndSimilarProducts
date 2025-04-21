package com.backenddevtest.similarproducts.infraestructure.adapters.output;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.backenddevtest.similarproducts.core.model.Product;
import com.backenddevtest.similarproducts.core.ports.ProductRepository;
import com.backenddevtest.similarproducts.infraestructure.adapters.output.mappers.ProductMappers;
import com.backenddevtest.similarproducts.infraestructure.documents.ProductDocument;

@Repository
public class MongoProductRepository implements ProductRepository{

    private final MongoTemplate mongoTemplate;

    public MongoProductRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public void save(Product product) {
        ProductDocument document = ProductMappers.toDocument(product);
        mongoTemplate.save(document);
    }
    
}
