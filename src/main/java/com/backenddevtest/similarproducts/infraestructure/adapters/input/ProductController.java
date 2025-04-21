package com.backenddevtest.similarproducts.infraestructure.adapters.input;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.backenddevtest.similarproducts.core.service.ProductService;
import com.backenddevtest.similarproducts.infraestructure.adapters.output.mappers.ProductMappers;
import com.backenddevtest.similarproducts.infraestructure.dto.ProductResponseDTO;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.MediaType;


@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{productId}/similar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductResponseDTO>> getSimilarProducts(@PathVariable String productId) {

        log.info("GET /product/{}/similar called", productId);
        
        if(!productService.productExists(productId)){
            log.error("Product {} not found", productId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "PRODUCT NOT FOUND");
        }


        return ResponseEntity.ok(
            productService.getSimilarProducts(productId).stream()
            .map(ProductMappers::toResponse)
            .collect(Collectors.toList())
        );
        
        // List<ProductResponse> response = productService.getSimilarProducts(productId)
        //     .stream()
        //     .map(ProductMappers::toResponse)
        //     .collect(Collectors.toList());
        // return ResponseEntity.ok(response);


    }
    

    // @GetMapping("/{productId}/similar")
    // public ResponseEntity<List<ProductDetailsDTO>> getSimilarProducts(@PathVariable String productId) {
        
    //     log.info("GETSIMILARPRODUCTS CALLED WITH ID: {}",productId);
    //     if (productService.productExists(productId)) {
    //         log.error("GETSIMILARPRODUCTS ERROR, NOT FOUND OBJECT WITH ID : {}",productId);
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "PRODUCT NOT FOUND");
            
    //     }


    //     return productService.getSimilarProductsDetailsList(productId);
    // }

}
