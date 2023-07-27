package com.example.demo.service;

import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(Integer productId) throws ProductNotFoundException {
        return productRepository
                .findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(String.format("Product с идентификатором: %s не найден!", productId)));
    }
}
