package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Product;
import java.util.List;

public interface productsService {
	Product saveProduct(Product product);
	List<Product> getAllProducts();
	Product getProductById(long id);
	Product updateProduct(Product product, long id);
	void deleteProduct(long id);
}
