package com.example.toystorey.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class AmazonConfig {
    Map<String,String> env = System.getenv();
    String access_key = env.get("AWS_ACCESS_KEY_ID");
    String secret_key = env.get("AWS_SECRET_ACCESS_KEY");

    @Bean
    public AmazonS3 s3() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(access_key,secret_key);

        return AmazonS3ClientBuilder
                .standard()
                .withRegion(env.get("AWS_DEFAULT_REGION"))
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }

}
