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
-  📦 Postman collection for API testing

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
### API Testing with Postman
A ready-to-use Postman collection is available in PostmanCollection in this repository.
Features include:
- Preconfigured requests with examples
- Automated response validation
- Environment variables setup
- Error scenario testing

**Import the collection**:
1. Download the collection file
2. Open Postman → Import → File
3. Select the JSON file
4. Set environment variable:
   ```text
   base_url = http://localhost:5000
   ```

**Test scenarios included**:
- Successful product retrieval (200 OK)
- Non-existent product handling (404 Not Found)
- Service unavailable scenarios (500 errors)

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/REPLACE_WITH_YOUR_COLLECTION_ID)
