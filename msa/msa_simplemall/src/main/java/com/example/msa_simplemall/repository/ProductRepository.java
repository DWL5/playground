package com.example.msa_simplemall.repository;

import com.example.msa_simplemall.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
