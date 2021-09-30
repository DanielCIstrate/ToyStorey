package com.example.toystorey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class ToyImage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    @Column(name = "image_type")
    private String imageType;

    @Lob
    @Column(name = "image_file")
    private byte[] imageFIle;




    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "toyImage")
    private Product product;

    public ToyImage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {return name; }

    public void setName(String name) {this.name = name; }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String type) {
        this.imageType = type;
    }

    public byte[] getImageFIle() {
        return imageFIle;
    }

    public void setImageFIle(byte[] image_file) {
        this.imageFIle = image_file;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
