package com.example.toystorey.repositories;

import com.example.toystorey.model.ToyImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ToyImage,Long> {
}
