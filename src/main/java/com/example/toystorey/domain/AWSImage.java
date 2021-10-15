package com.example.toystorey.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AWSImage {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private String imagePath;
    private String imageFileName;

}