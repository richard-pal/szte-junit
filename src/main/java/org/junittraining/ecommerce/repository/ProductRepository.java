package org.junittraining.ecommerce.repository;

import org.junittraining.ecommerce.entity.Product;

/** Interface to retrieve product information (for example from a database) */
public interface ProductRepository {
    Product getById(String id);
}
