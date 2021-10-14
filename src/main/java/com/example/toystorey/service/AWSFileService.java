package com.example.toystorey.service;

import com.example.toystorey.domain.AWSImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AWSFileService {
    AWSImage saveImage(String title, String description, MultipartFile file);

    byte[] downloadAWSImage(Long id);

    List<AWSImage> getAllAWSImages();
}
