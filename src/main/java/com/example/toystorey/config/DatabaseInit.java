package com.example.toystorey.config;

import com.example.toystorey.domain.Product;
import com.example.toystorey.domain.ToyProduct;
import com.example.toystorey.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DatabaseInit implements ApplicationRunner {

    private ProductRepository productRepository;

    @Autowired
    public DatabaseInit(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
//        Product bowlingSet = new ToyProduct(null,"Bowling set", 80.00,4);
//        Product doctorSet = new ToyProduct(null,"Set doctor", 125.00, 6);
//        Product cardSet = new ToyProduct(null,"Playing cards", 20.00,7);
//
//        productRepository.save(bowlingSet);
//        productRepository.save(doctorSet);
//        productRepository.save(cardSet);

    }
}
