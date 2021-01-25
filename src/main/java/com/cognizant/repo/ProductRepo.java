package com.cognizant.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

	Optional<Product> findByName(String product_name);

}
