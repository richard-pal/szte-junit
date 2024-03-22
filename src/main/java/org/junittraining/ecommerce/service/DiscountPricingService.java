package org.junittraining.ecommerce.service;

import org.junittraining.ecommerce.entity.Product;
import org.junittraining.ecommerce.repository.ProductRepository;

/** Service to calculate discounted product price. */
public class DiscountPricingService {
    
    private ProductRepository productRepository;
    private double discountPercent;

    // The implementation of this constructor is intentionally not fully correct.
    // What issues can you identify?
    public DiscountPricingService(ProductRepository productRepository, double discountPercent) {
        this.productRepository = productRepository;
        this.discountPercent = discountPercent;
    }

    // The implementation of this function is intentionally not fully correct.
    // What issues can you identify?
    public Double getProductPrice(final String productId) {
        Product product = productRepository.getById(productId);
        return product.getPrice() * (100 - this.discountPercent) / 100;
    }
}
