package com.erenkurt.venderingapp.Product;

import com.erenkurt.venderingapp.Product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {
    Product findByProductId(Integer productId);
}
