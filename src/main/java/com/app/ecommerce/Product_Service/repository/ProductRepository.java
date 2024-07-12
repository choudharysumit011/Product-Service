package com.app.ecommerce.Product_Service.repository;

import com.app.ecommerce.Product_Service.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
