package com.cognizant.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.model.Cart;
import com.cognizant.model.ProductVendor;

public interface ProductVendorRepo extends JpaRepository<ProductVendor, Long> {

}
