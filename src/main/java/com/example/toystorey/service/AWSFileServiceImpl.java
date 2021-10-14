package com.example.toystorey.service;

import com.example.toystorey.config.BucketName;
import com.example.toystorey.domain.AWSImage;
import com.example.toystorey.repositories.AWSImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Service
@AllArgsConstructor
public class AWSFileServiceImpl implements AWSFileService{
    private final AWSFileStore fileStore;
    private final AWSImageRepository awsImageRepository;

    @Override
    public AWSImage saveImage(String title, String description, MultipartFile file) {
        //check if the file is empty
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }
        //check if file is an image
        if(!Arrays.asList(IMAGE_PNG.getMimeType(), IMAGE_BMP.getMimeType(), IMAGE_GIF.getMimeType(),
                IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("File uploaded is not an image");
        }
        //get metadata from file
        Map<String,String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        String path = String.format("%s/%s", BucketName.TOY_IMAGE.getBucketName(), UUID.randomUUID());
        String fileName = String.format("%s", file.getOriginalFilename());
        try {
            fileStore.upload(path, fileName, Optional.of(metadata),file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to upload file",e);
        }
        AWSImage toyImage = AWSImage.builder()
                .description(description)
                .title(title)
                .imagePath(path)
                .imageFileName(fileName)
                .build();
        awsImageRepository.save(toyImage);

        return awsImageRepository.findByTitle(toyImage.getTitle());
    }

    @Override
    public byte[] downloadAWSImage(Long id) throws IllegalStateException {
        if (awsImageRepository.findById(id).isPresent()) {
            AWSImage toyImage = awsImageRepository.findById(id).get();
            return fileStore.download(toyImage.getImagePath(), toyImage.getImageFileName());
        } else {
            throw new IllegalStateException("Image with id " + id + " not found");
        }

    }

    @Override
    public List<AWSImage> getAllAWSImages() {
        List<AWSImage> images = new ArrayList<>();
        awsImageRepository.findAll().forEach(images::add);
        return images;
    }
}
