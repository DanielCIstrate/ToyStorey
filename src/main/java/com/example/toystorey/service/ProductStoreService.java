package com.example.toystorey.service;

import com.example.toystorey.domain.Product;

import java.util.List;

public interface ProductStoreService {
    List<Product> getAllProducts();
    default String getProductURLbyID(Long id) {
        return "http://localhost:8080/api/v1/toy_image/" + id + "/image/download";
    }
    void save(Product product);
}
