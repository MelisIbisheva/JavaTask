import org.example.Client;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClientTest {
    @Test
    public void testClientDiscount() {
        // Test case for basic discount
        Client client = new Client(1, "Test Client", 0.1, 0.2, 0.3);
        assertEquals(90.0, client.clientDiscount(100), 0.01);
    }


    @Test
    public void testClientDiscountWithZeroBasicDiscount() {
        Client client = new Client(1, "Test Client", 0.0, 0.2, 0.3);
        assertEquals(100.0, client.clientDiscount(100.0), 0.01);
    }

    @Test
    public void testClientDiscountWithZeroTotalPrice() {
        Client client = new Client(1, "Test Client", 0.1, 0.2, 0.3);
        assertEquals(0.0, client.clientDiscount(0.0), 0.01);
    }


    @Test
    public void testDiscountBelow10000() {
        Client client = new Client(1, "Test Client", 0.1, 0.2, 0.3);
        assertEquals(5000.0, client.discountAbove(5000.0), 0.01);
    }

    @Test
    public void testDiscountWithZeroTotalPrice() {
        Client client = new Client(1, "Test Client", 0.1, 0.2, 0.3);
        assertEquals(0.0, client.discountAbove(0.0), 0.01);
    }

    @Test
    public void testDiscountWithNegativeTotalPrice() {
        Client client = new Client(1, "Test Client", 0.1, 0.2, 0.3);
        assertEquals(-10000.0, client.discountAbove(-10000.0), 0.01);
    }


    @Test
    public void testAllDiscountWithBasicDiscountBelow10000() {
        Client client = new Client(1, "Test Client", 0.1, 0.2, 0.3);
        assertEquals(4500.0, client.allDiscount(5000.0), 0.01);
    }

    @Test
    public void testAllDiscountWithZeroTotalPrice() {
        Client client = new Client(1, "Test Client", 0.1, 0.2, 0.3);
        assertEquals(0.0, client.allDiscount(0.0), 0.01);
    }
}
