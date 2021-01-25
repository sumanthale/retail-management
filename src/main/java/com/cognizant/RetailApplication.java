package com.cognizant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Cart;
import com.cognizant.model.Product;
import com.cognizant.model.ProductVendor;
import com.cognizant.model.Vendor;
import com.cognizant.model.VendorWishlist;
import com.cognizant.repo.CartRepo;
import com.cognizant.repo.ProductRepo;
import com.cognizant.repo.ProductVendorRepo;
import com.cognizant.repo.VendorRepo;
import com.cognizant.repo.VendorWishlistRepo;

@SpringBootApplication
@RestController
public class RetailApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RetailApplication.class, args);
	}

	@Autowired
	ProductRepo productRepo;
	@Autowired
	VendorRepo vendorRepo;
	@Autowired
	CartRepo cartRepo;
	@Autowired
	ProductVendorRepo pvrepo;

	@Autowired
	VendorWishlistRepo wishlistRepo;

	@Override
	public void run(String... args) throws Exception {

	}

//	@GetMapping("/data/{id}")
//	public List<Product> data(@PathVariable Long id) {
//		Vendor vendor = vendorRepo.findById(id).get();
//		System.out.prLongln(vendor.getProducts());
//		return vendor.getProducts();
//	}  

	@GetMapping("/insert")
	public List<ProductVendor> insert() {
		Vendor vendor = new Vendor("Sumanth", 1000, 5);

		Vendor vendor2 = new Vendor("Sunny", 1000, 5);

		Product product = new Product(100, "Apple desc", "Apple", "url", 2);
		Product product2 = new Product(100, "Andriod desc", "GOogle", "url", 2);

		productRepo.save(product);
		productRepo.save(product2);
		vendorRepo.save(vendor);
		vendorRepo.save(vendor2);

		ProductVendor productVendor = new ProductVendor(product, vendor, 5, "today");
		ProductVendor productVendor2 = new ProductVendor(product2, vendor2, 5, "next today");
		pvrepo.save(productVendor);
		pvrepo.save(productVendor2);
		List<ProductVendor> findAll = pvrepo.findAll();

		return findAll;

	}

	/* Product microService */

	@GetMapping("searchProductById/{product_id}")
	public ResponseEntity<Product> searchProductById(@PathVariable Long product_id) {

		Optional<Product> product = productRepo.findById(product_id);
		if (product.isPresent()) {
			return new ResponseEntity<Product>(product.get(), HttpStatus.OK);

		} else {
			return new ResponseEntity<Product>(new Product(), HttpStatus.OK);
		}
	}

	@GetMapping("searchProductByName/{product_name}")
	public ResponseEntity<Product> searchProductByName(@PathVariable String product_name) {

		Optional<Product> product = productRepo.findByName(product_name);
		if (product.isPresent()) {
			return new ResponseEntity<Product>(product.get(), HttpStatus.OK);

		} else {
			return new ResponseEntity<Product>(new Product(), HttpStatus.OK);
		}
	}

	@GetMapping("addProductRating/{product_id}/{rating}")
	public ResponseEntity<Product> searchProductById(@PathVariable Long product_id, @PathVariable int rating) {

		Optional<Product> product = productRepo.findById(product_id);
		if (product.isPresent()) {
			Product product2 = product.get();
			product2.setRating(rating);
			productRepo.save(product2);
			return new ResponseEntity<Product>(product2, HttpStatus.OK);

		} else {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	/* Product microService End */

	/* ProceedToBuy MicroServices */

	@GetMapping("addProductToCart/{product_id}/{vendor_id}/{zipcode}/{date}")
	public ResponseEntity<Cart> addProductToCart(@PathVariable Long product_id, @PathVariable Long vendor_id,
			@PathVariable String zipcode, @PathVariable String date) {

		Product product = productRepo.findById(product_id).get();
		Vendor vendor = vendorRepo.findById(vendor_id).get();
		Cart cart = new Cart(product, vendor, zipcode, date);
		cartRepo.save(cart);

		return new ResponseEntity<Cart>(cart, HttpStatus.OK);

	}

	@GetMapping("addProductToWishlist/{product_id}/{vendor_id}")
	public ResponseEntity<VendorWishlist> addProductToWishlist(@PathVariable Long product_id,
			@PathVariable Long vendor_id) {

		Product product = productRepo.findById(product_id).get();
		Vendor vendor = vendorRepo.findById(vendor_id).get();
		VendorWishlist wishlist = new VendorWishlist(product, vendor, 1, new Date().toString());
		wishlistRepo.save(wishlist);

		return new ResponseEntity<VendorWishlist>(wishlist, HttpStatus.OK);

	}

	@GetMapping("wishlist")
	public List<VendorWishlist> getWishList() {
		return wishlistRepo.findAll();
	}

	@GetMapping("cart")
	public List<Cart> cart() {

		List<Cart> findAll = cartRepo.findAll();
		System.out.println(findAll.toString());

//		for (Cart cart : findAll) {
//			Product product = cart.getProduct();
//			Vendor vendor = cart.getVendor();
//			System.out.println(product);
//			System.out.println(vendor);
//		}
		return findAll;
	}

	/* ProceedToBuy MicroServices End */

	/* Vendor MicroService */

	@GetMapping("/getvendorDetails/{product_id}")
	public List<Vendor> getVendors(@PathVariable Long product_id) {
		Product product = productRepo.findById(product_id).get();

		List<ProductVendor> productVendors = product.getVendors();
		List<Vendor> vendors = new ArrayList<Vendor>();

		for (ProductVendor productVendor : productVendors) {
			Vendor vendor = productVendor.getVendor();
			vendors.add(vendor);
		}

		return vendors;
	}

	/* Vendor MicroService End */

}
