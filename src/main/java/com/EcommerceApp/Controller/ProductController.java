package com.EcommerceApp.Controller;

import java.util.List;
import javax.validation.Valid;
import com.EcommerceApp.Models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.EcommerceApp.Service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/")
public class ProductController {
	@Autowired
	ProductService ps;

	@GetMapping("getProduct")
	public ResponseEntity<List<Product>> findProductDetail() {
		return new ResponseEntity<>(ps.findProductDetail(), HttpStatus.OK);
	}

	@PostMapping("postProduct")
	public ResponseEntity<Object> enterProductDetail(@Valid @RequestBody Product product) {
		ps.postProduct(product);
		return new ResponseEntity<Object>("Inserted Succssfully", HttpStatus.OK);
	}

	@PutMapping("updateProduct")
	public ResponseEntity<Object> updateDetails(@RequestParam(required = false) float price,
			@RequestParam(required = false) int pid) {
		ps.putProduct(pid, price);
		return new ResponseEntity<>("Updated successsfully", HttpStatus.OK);
	}

	@DeleteMapping("deleteProductByPrice")
	public ResponseEntity<Object> deleteProductByPrice(@RequestParam(required = false) float price) {
		ps.deleteProductByPrice(price);
		return new ResponseEntity<>("Deleted successsfully", HttpStatus.OK);
	}
}
