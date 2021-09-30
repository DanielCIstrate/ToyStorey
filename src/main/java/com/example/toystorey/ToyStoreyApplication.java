package com.example.toystorey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ToyStoreyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToyStoreyApplication.class, args);
    }

}
