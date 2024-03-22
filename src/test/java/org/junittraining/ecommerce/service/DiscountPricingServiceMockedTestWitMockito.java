package org.junittraining.ecommerce.service;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junittraining.ecommerce.entity.Product;
import org.junittraining.ecommerce.exception.ProductHasNoPriceException;
import org.junittraining.ecommerce.exception.ProductNotFoundException;
import org.junittraining.ecommerce.repository.ProductRepository;

public class DiscountPricingServiceMockedTestWitMockito {

    private ProductRepository mockRepository;

    @Before
    public void setup() {
        // use Mockito to construct a "mock" implementation that returns a
        // product we would like to use during this testcase:
        mockRepository = mock(ProductRepository.class);
        
        // "teach" the mock:
        when(mockRepository.getById("IC-001")).thenReturn(new Product("IC-001", "Ice cream", 1000d));
        when(mockRepository.getById("IC-002")).thenReturn(new Product("IC-002", "Froyo", 500d));
        when(mockRepository.getById("missing-price")).thenReturn(new Product("ID-missing-price", "Ice cream", null));
        when(mockRepository.getById("not-existing-product")).thenThrow(new ProductNotFoundException());
    }

    @Test
    public void testNoDiscountReturnsTheOriginalPrice() {
        // use the above mock repository to construct the service:
        final DiscountPricingService service = new DiscountPricingService(mockRepository, 0);
        assertThat(service.getProductPrice("IC-001")).isEqualTo(1000d);
    }

    @Test
    public void testTenPercentDiscountTest() {
        final DiscountPricingService service = new DiscountPricingService(mockRepository, 10);
        assertThat(service.getProductPrice("IC-002")).isEqualTo(450d);
    }

    @Test(expected = ProductHasNoPriceException.class) // this test fails for demonstration purposes.
    public void testNoPriceIsAvailable() {

        final DiscountPricingService service = new DiscountPricingService(mockRepository, 10);
        service.getProductPrice("missing-price");
    }

    @Test(expected = ProductNotFoundException.class)
    public void testNotExistingProduct() {
        
        final DiscountPricingService service = new DiscountPricingService(mockRepository, 10);
        service.getProductPrice("not-existing-product");
    }

    // Note: More testcases need to be added for proper testing of the service.
}
