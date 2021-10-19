package com.example.toystorey.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class ToyProduct extends Product {
    private Integer recommendedAge;

    public ToyProduct(){

    }
    public ToyProduct(Long id, String name, Double price, Integer recommendedAge) {
        super(id, name, price);
        this.recommendedAge = recommendedAge;
    }

    public Integer getRecommendedAge() {
        return recommendedAge;
    }

    public void setRecommendedAge(Integer recommendedAge) {
        this.recommendedAge = recommendedAge;
    }
}
