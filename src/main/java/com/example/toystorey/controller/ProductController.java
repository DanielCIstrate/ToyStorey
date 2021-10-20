package com.example.toystorey.controller;

import com.example.toystorey.domain.Product;
import com.example.toystorey.service.ProductStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
@CrossOrigin(value="*",maxAge = 3600)
public class ProductController {

    private final ProductStoreService productStoreService;

    @Autowired
    public ProductController(ProductStoreService productStoreService) {
        this.productStoreService = productStoreService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productStoreService.getAllProducts();
    }
}
