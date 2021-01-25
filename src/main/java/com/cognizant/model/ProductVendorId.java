package com.cognizant.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProductVendorId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long productId;
	private Long vendorId;

	public ProductVendorId() {
	}

	public ProductVendorId(Long productId, Long vendorId) {
		super();
		this.productId = productId;
		this.vendorId = vendorId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

}