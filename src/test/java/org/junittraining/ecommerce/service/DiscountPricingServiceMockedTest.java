package org.junittraining.ecommerce.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junittraining.ecommerce.entity.Product;
import org.junittraining.ecommerce.exception.ProductHasNoPriceException;
import org.junittraining.ecommerce.exception.ProductNotFoundException;
import org.junittraining.ecommerce.repository.ProductRepository;

public class DiscountPricingServiceMockedTest {
    
    @Test
    public void testNoDiscountReturnsTheOriginalPrice() {
        
        // use an anonymous inner class to construct a "mock" implementation that returns a
        // product we would like to use during this testcase:
        final ProductRepository mockRepository = new ProductRepository() {
            @Override
            public Product getById(String id) {
                // return a mock Product instance that is suitable for this testcase:
                return new Product("IC-001", "Ice cream", 1000d);
            }
        };

        // use the above mock repository to construct the service:
        final DiscountPricingService service = new DiscountPricingService(mockRepository, 0);
        assertThat(service.getProductPrice("dummy")).isEqualTo(1000d);
    }

    @Test
    public void testTenPercentDiscountTest() {
        
        final ProductRepository mockRepository = new ProductRepository() {
            @Override
            public Product getById(String id) {
                return new Product("IC-002", "Froyo", 500d);
            }
        };

        final DiscountPricingService service = new DiscountPricingService(mockRepository, 10);
        assertThat(service.getProductPrice("dummy")).isEqualTo(450d);
    }

    @Test(expected = ProductHasNoPriceException.class)  // this test fails for demonstration purposes.
    public void testNoPriceIsAvailable() {
        
        final ProductRepository mockRepository = new ProductRepository() {
            @Override
            public Product getById(String id) {
                return new Product("IC-001", "Ice cream", null);
            }
        };

        final DiscountPricingService service = new DiscountPricingService(mockRepository, 10);
        service.getProductPrice("dummy");
    }

    @Test(expected = ProductNotFoundException.class)
    public void testNotExistingProduct() {
        
        final ProductRepository mockRepository = new ProductRepository() {
            @Override
            public Product getById(String id) {
                throw new ProductNotFoundException();
            }
        };

        final DiscountPricingService service = new DiscountPricingService(mockRepository, 10);
        service.getProductPrice("dummy");
    }

    // Note: More testcases need to be added for proper testing of the service.
}
