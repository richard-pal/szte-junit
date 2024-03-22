package org.junittraining.ecommerce.entity;

public class Product {
    
    private String id;
    private String name;
    private Double price;

    public Product(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Double getPrice() {
		return price;
	}
}
