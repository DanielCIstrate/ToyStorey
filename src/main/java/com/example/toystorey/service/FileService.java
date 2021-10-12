package com.example.toystorey.service;

import com.example.toystorey.model.ToyImage;
import com.example.toystorey.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FileService implements FileStoreInterface{

    private final ImageRepository imageRepository;

    @Autowired
    public FileService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public void save(MultipartFile file) throws IOException {
        ToyImage toyImage = new ToyImage();
        toyImage.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        toyImage.setImageType(file.getContentType());
        toyImage.setImageFIle(file.getBytes());

        imageRepository.save(toyImage);
    }

    public Optional<ToyImage> getToyImageFile(Long id) {
        return imageRepository.findById(id);
    }

    public List<ToyImage> getAllToyImages() {
        return imageRepository.findAll();
    }

    @Override
    public String getImageURLByID(Long id) {
        return "";
    }
}
