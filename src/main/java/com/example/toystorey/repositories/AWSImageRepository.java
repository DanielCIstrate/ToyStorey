package com.example.toystorey.repositories;

import com.example.toystorey.domain.AWSImage;
import org.springframework.data.repository.CrudRepository;

public interface AWSImageRepository extends CrudRepository<AWSImage, Long> {
    AWSImage findByTitle(String title);

}
