package com.example.demo.controller;

import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    ProductService productService;

    @GetMapping
    public Product getProduct(@RequestParam("productId") Integer productId) throws ProductNotFoundException {
        return productService.getProductById(productId);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) throws ProductNotFoundException {
        productService.createProduct(product);
        return getProduct(product.getId());
    }
}
