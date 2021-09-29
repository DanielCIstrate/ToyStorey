package com.example.toystorey.config;

import com.example.toystorey.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
public class DatabaseInit implements ApplicationRunner {

    private EntityManager entityManager;

    @Autowired
    public DatabaseInit(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Product tricicletaAlba = new Product("Tricicleta alba",329.99);
        Product tricletaRosie = new Product("Tricicleta rosie", 159.99);

        entityManager.persist(tricicletaAlba);
        entityManager.persist(tricletaRosie);



    }
}
