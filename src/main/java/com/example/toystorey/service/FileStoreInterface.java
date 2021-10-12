package com.example.toystorey.service;

import com.example.toystorey.model.ToyImage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface FileStoreInterface {
    public String getImageURLByID(Long id);

    public void save(MultipartFile file) throws IOException;

    public Optional<ToyImage> getToyImageFile(Long id);

    public List<ToyImage> getAllToyImages();

}
