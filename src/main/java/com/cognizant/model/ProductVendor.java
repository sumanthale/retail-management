package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ProductVendor {
	@EmbeddedId
	private ProductVendorId id = new ProductVendorId();

	@ManyToOne
	@MapsId("productId")
	@JsonManagedReference
	private Product product;

	@ManyToOne
	@MapsId("vendorId")
	@JsonManagedReference
	private Vendor vendor;

	@Column(name = "stock")
	private int stock;
	@Column(name = "expected_date")
	private String expectedDate;

	public ProductVendor() {
	}

	public ProductVendor(Product product, Vendor vendor, int stock, String expectedDate) {
		this.product = product;
		this.vendor = vendor;
		this.stock = stock;
		this.expectedDate = expectedDate;
	}

	public ProductVendor(Product product, Vendor vendor) {
		this.product = product;
		this.vendor = vendor;
	}

	public ProductVendorId getId() {
		return id;
	}

	public void setId(ProductVendorId id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(String expectedDate) {
		this.expectedDate = expectedDate;
	}

}
