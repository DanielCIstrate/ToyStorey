package com.example.toystorey.controller;

import com.example.toystorey.model.ToyImage;
import com.example.toystorey.model.ToyImageResponse;
import com.example.toystorey.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("files")
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        try{
            fileService.save(file);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(String.format("File uploaded successfully: %s", file.getOriginalFilename()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(String.format("Could not upload the file: %s!",file.getOriginalFilename()));
        }
    }

    @GetMapping
    public List<ToyImageResponse> list() {
        return fileService.getAllToyImages()
                .stream()
                .map(this::mapToToyImageResponse)
                .collect(Collectors.toList());
    }

    private ToyImageResponse mapToToyImageResponse(ToyImage toyImage) {
        String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/")
                .path(toyImage.getId().toString())
                .toUriString();

        ToyImageResponse toyImageResponse = new ToyImageResponse();

        toyImageResponse.setId(toyImage.getId());
        toyImageResponse.setName(toyImage.getName());
        toyImageResponse.setImageType(toyImage.getImageType());
        toyImageResponse.setUrl(downloadURL);

        return toyImageResponse;
    }

    @GetMapping("{id}")
    public ResponseEntity<byte[]> getToyImage(@PathVariable String id) {
        Optional<ToyImage> toyImageOptional = fileService.getToyImageFile(Long.parseLong(id));

        if(!toyImageOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        ToyImage toyImage = toyImageOptional.get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + toyImage.getName() + "\"")
                .contentType(MediaType.valueOf(toyImage.getImageType()))
                .body(toyImage.getImageFIle());
    }

    
}
