package com.example.toystorey.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BucketName {
    TOY_IMAGE("toy-storey-amazon-storage");
    private final String bucketName;
}
