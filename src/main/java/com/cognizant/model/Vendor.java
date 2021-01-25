package com.cognizant.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany; 

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int deliveryCharge;
	private int rating;

//	@OneToOne(mappedBy = "vendor")
//	@JsonManagedReference
//	private Cart cart;
//
//	@OneToOne(mappedBy = "vendor", fetch = FetchType.LAZY)
//	private VendorWishlist vendorWishlist;

	@OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<ProductVendor> products = new ArrayList<>(0);

	public Vendor() {
	}

	public Vendor(String name, int deliveryCharge, int rating) {

		this.name = name;
		this.deliveryCharge = deliveryCharge;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(int deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

//	public void addProduct(Product product) {
//		ProductVendor productvendor = new ProductVendor(product, this);
//		getProducts().add(productvendor);
//		product.getVendors().add(productvendor);
//	}

//	public void removeProduct(Vendor vendor) {
//		for (Iterator<ProductVendor> iterator = getProducts().iterator(); iterator.hasNext();) {
//			ProductVendor ProductVendor = iterator.next();
//
//			if (ProductVendor.getProduct().equals(this) && ProductVendor.getVendor().equals(vendor)) {
//				iterator.remove();
//				ProductVendor.getVendor().getProducts().remove(ProductVendor);
//				ProductVendor.setProduct(null);
//				ProductVendor.setVendor(null);
//			}
//		}
//	}

	public List<ProductVendor> getProducts() {
		return products;
	}

	public void setProducts(List<ProductVendor> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", deliveryCharge=" + deliveryCharge + ", rating=" + rating
				+ "]";
	}

//	public Cart getCart() {
//		return cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}

}
