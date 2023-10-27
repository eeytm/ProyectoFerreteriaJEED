package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.repository.productsRepository;
import net.javaguides.springboot.service.productsService;

import java.util.Optional;
import java.util.List;

@Service
public class productsServiceImpl implements productsService {

	private productsRepository productsRepository;

	public productsServiceImpl(productsRepository productsRepository) {
		super();
		this.productsRepository = productsRepository;
	}

	@Override
	public Product saveProduct(Product product) {
		return productsRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productsRepository.findAll();
	}

	@Override
	public Product getProductById(long id) {
		Optional<Product> product = productsRepository.findById(id);
		if (product.isPresent()) {
			return product.get();
		} else {
			throw new ResourceNotFoundException("Product", "Id", id);
		}
	}

	@Override
	public Product updateProduct(Product product, long id) {
		Product existingProduct = productsRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Product", "Id", id));
		existingProduct.setCodName(product.getCodName());
		existingProduct.setProductName(product.getProductName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		productsRepository.save(existingProduct);
		return existingProduct;
	}

	@Override
	public void deleteProduct(long id) {
		productsRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("Product", "Id", id));
		productsRepository.deleteById(id);
	}
}
