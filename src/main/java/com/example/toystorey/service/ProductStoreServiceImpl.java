package com.example.toystorey.service;

import com.example.toystorey.domain.Product;
import com.example.toystorey.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductStoreServiceImpl implements ProductStoreService{
    private final ProductRepository productRepository;

    @Autowired
    public ProductStoreServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Optional<Product> getProductByID(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
