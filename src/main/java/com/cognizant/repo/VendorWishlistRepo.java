package com.cognizant.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.model.VendorWishlist;

public interface VendorWishlistRepo extends JpaRepository<VendorWishlist, Long> {

}
