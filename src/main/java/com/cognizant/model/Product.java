package com.cognizant.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int price;
	private String description;
	private String name;
	private String image;
	private int rating;

//	@OneToOne(mappedBy = "product", fetch = FetchType.LAZY)
//	@JsonManagedReference
//	private Cart cart;
//	@OneToOne(mappedBy = "product", fetch = FetchType.LAZY)
//	private VendorWishlist vendorWishlist;

	
	
	@OneToMany(mappedBy = "product")
	@JsonBackReference
	private List<ProductVendor> vendors = new ArrayList<>(0);

	public Product() {
	}

	public Product(int price, String description, String name, String image, int rating) {
		this.price = price;
		this.description = description;
		this.name = name;
		this.image = image;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getimage() {
		return image;
	}

	public void setimage(String image) {
		this.image = image;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void addVendor(Vendor Vendor) {
		ProductVendor productvendor = new ProductVendor(this, Vendor);
		getVendors().add(productvendor);
		Vendor.getProducts().add(productvendor);
	}

	public void removeVendor(Vendor vendor) {
		for (Iterator<ProductVendor> iterator = getVendors().iterator(); iterator.hasNext();) {
			ProductVendor productVendor = iterator.next();

			if (productVendor.getProduct().equals(this) && productVendor.getVendor().equals(vendor)) {
				iterator.remove();
				productVendor.getVendor().getProducts().remove(productVendor);
				productVendor.setProduct(null);
				productVendor.setVendor(null);
			}
		}
	}

	public List<ProductVendor> getVendors() {
		return vendors;
	}

	public void setVendors(List<ProductVendor> vendors) {
		this.vendors = vendors;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", description=" + description + ", name=" + name + ", image="
				+ image + ", rating=" + rating + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

//	public Cart getCart() {
//		return cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}
//
//	public VendorWishlist getVendorWishlist() {
//		return vendorWishlist;
//	}
//
//	public void setVendorWishlist(VendorWishlist vendorWishlist) {
//		this.vendorWishlist = vendorWishlist;
//	}

}
