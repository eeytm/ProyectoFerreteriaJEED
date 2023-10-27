package net.javaguides.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.service.productsService;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class productsController {

	private productsService productsService;

	public productsController(productsService productsService) {
		super();
		this.productsService = productsService;
	}

	@PostMapping()
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productsService.saveProduct(product), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return productsService.getAllProducts();
	}

	@GetMapping("{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
		return new ResponseEntity<Product>(productsService.getProductById(id), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
		return new ResponseEntity<Product>(productsService.updateProduct(product, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") long id) {
		productsService.deleteProduct(id);
		return new ResponseEntity<String>("Product deleted successfully.", HttpStatus.OK);
	}
}
