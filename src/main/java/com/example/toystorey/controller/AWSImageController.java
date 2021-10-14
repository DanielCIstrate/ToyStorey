package com.example.toystorey.controller;

import com.example.toystorey.domain.AWSImage;
import com.example.toystorey.service.AWSFileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/toy_image")
@AllArgsConstructor
@CrossOrigin("*")
public class AWSImageController {
    AWSFileService fileService;

    @GetMapping
    public ResponseEntity<List<AWSImage>> getToyImages() {
        return new ResponseEntity<>(fileService.getAllAWSImages(), HttpStatus.OK);
    }

    @PostMapping(
            path = "",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AWSImage> saveImage(@RequestParam("title") String title,
                                              @RequestParam("description") String description,
                                              @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(fileService.saveImage(title,description,file), HttpStatus.OK);
    }

    @GetMapping(value = "{id}/image/download")
    public byte[] downloadToyImage(@PathVariable("id") Long id) {
        return fileService.downloadAWSImage(id);
    }


}
