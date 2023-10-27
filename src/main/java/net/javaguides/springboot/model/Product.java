package net.javaguides.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "codName", nullable = false)
	private String codName;

	@Column(name = "productName", nullable = false)
	private String productName;

	@Column(name = "quantity", nullable = true)
	private int quantity;

	@Column(name = "price", nullable = true)
	private double price;
}
