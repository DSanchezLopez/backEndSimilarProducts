package com.backenddevtest.similarproducts.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.backenddevtest.similarproducts.")
public class SimilarproductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimilarproductsApplication.class, args);
	}

}
