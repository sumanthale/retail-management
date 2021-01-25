package com.cognizant.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.model.Cart;

public interface CartRepo extends JpaRepository<Cart, Long> {

}
