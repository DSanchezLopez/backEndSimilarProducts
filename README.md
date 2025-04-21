# Similar Products Service

[![Java Version](https://img.shields.io/badge/Java-21%2B-blue)](https://adoptium.net/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1%2B-brightgreen)](https://spring.io/projects/spring-boot)
[![MongoDB](https://img.shields.io/badge/MongoDB-5.0%2B-green)](https://www.mongodb.com/)

A Spring Boot service implementing **Hexagonal Architecture** to fetch and manage similar product data with external API integration and MongoDB persistence.

## Features
- 🏛️ Hexagonal Architecture pattern
- 🔄 External API integration with resilience patterns
- 🗄️ MongoDB data persistence
- 🐳 Dockerized MongoDB setup
- 📡 REST API endpoints
- 🛡️ Fallback mechanisms for failed requests

## Prerequisites
- Java 21+
- Maven 3.8+
- Docker 20.10+
- MongoDB 5.0+

## Installation
```bash
git clone https://github.com/DSanchezLopez/similar-products-service.git
cd similar-products-service
mvn clean install
docker-compose up -d
mvn spring-boot:run
````
## Configuration
```bash
# application.properties
product-service.product-details-url=http://external-service/product/{productId}
product-service.product-similar-url=http://external-service/product/{productId}/similarids
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=product_db
````
## API Endpoints
-GET /product/{productId}/similar
```bash
curl -H "Accept: application/json" http://localhost:5000/product/1/similar
````
-Response
```bash
[
  {
    "id": "2",
    "name": "Premium Headphones",
    "price": 199.99,
    "availability": true
  }
]
````

