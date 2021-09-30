package com.example.toystorey.config;

import com.example.toystorey.model.Product;
import com.example.toystorey.model.ToyImage;
import com.example.toystorey.repositories.ImageRepository;
import com.example.toystorey.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
public class DatabaseInit implements ApplicationRunner {

//    private EntityManager entityManager;
//
//    @Autowired
//    public DatabaseInit(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    private ImageRepository imageRepository;
    private ProductRepository productRepository;

    @Autowired
    public DatabaseInit(ImageRepository imageRepository, ProductRepository productRepository) {
        this.imageRepository = imageRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Product tricicletaAlba = new Product("Tricicleta alba",329.99);
        Product tricletaRosie = new Product("Tricicleta rosie", 159.99);
        ToyImage pozica = new ToyImage();
        ToyImage poza2 = new ToyImage();
        tricicletaAlba.setToyImage(pozica);
        tricletaRosie.setToyImage(poza2);

        productRepository.save(tricicletaAlba);
        productRepository.save(tricletaRosie);





    }
}
