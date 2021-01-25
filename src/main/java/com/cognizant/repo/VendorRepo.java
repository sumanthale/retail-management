package com.cognizant.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.model.Vendor;

public interface VendorRepo extends JpaRepository<Vendor, Long> {

}
