import static org.junit.Assert.assertEquals;

import org.example.Product;
import org.junit.Test;

public class ProductTest {

    @Test
    public void testCalculateStandardUnitPriceForProductId1() {
        Product product = new Product(1, "Test Product", 10.0, 0.2, "");
        assertEquals(12.0, product.calculateStandardUnitPrice(), 0.01);
    }

    @Test
    public void testCalculateStandardUnitPriceForProductId2() {
        Product product = new Product(2, "Test Product", 15.0, 0.3, "");
        assertEquals(19.5, product.calculateStandardUnitPrice(), 0.01);
    }

    @Test
    public void testCalculateStandardUnitPriceWithZeroMarkup() {
        Product product = new Product(1, "Test Product", 10.0, 0.0, "");
        assertEquals(10.0, product.calculateStandardUnitPrice(), 0.01);
    }


    @Test
    public void testCalculatePromotionalUnitPriceForInvalidPromotion() {
        Product product = new Product(1, "Test Product", 10.0, 0.2, "Invalid Promotion");
        assertEquals(0.0, product.calculatePromotionalUnitPrice(), 0.01);
    }

    @Test
    public void testCalculatePromotionalUnitPriceForNegativeQuantity() {
        Product product = new Product(1, "Test Product", 10.0, 0.2, "Buy 2, get 3rd free");
        assertEquals(0.0, product.calculatePromotionalUnitPrice(-1), 0.01);
    }
}
