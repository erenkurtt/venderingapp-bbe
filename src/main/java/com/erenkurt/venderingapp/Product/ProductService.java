package com.erenkurt.venderingapp.Product;

import com.erenkurt.venderingapp.Product.Product;
import com.erenkurt.venderingapp.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getProducts () {
        return productRepository.findAll();
    }

    public Product getProduct(Integer productId) {
        return productRepository.findByProductId(productId);
    }

    public Product updateProduct(Integer productId, Product updatedProduct) {
        Product product = productRepository.findByProductId(productId);

        if (product != null) {
            // Update the existing product with data from updatedProduct
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());

            // Save the updated product to the repository
            return productRepository.save(product);
        } else {
            return null; // Product not found
        }
    }
}
