package com.example.toystorey.repositories;

import com.example.toystorey.model.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
    List<Product> findAllByName(String name, Pageable pageable);

    List<Product> findAllByPrice(double price, Pageable pageable);

}
