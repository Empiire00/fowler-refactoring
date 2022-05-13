package tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import classes.*;


public class TestCustomer {
    private Customer customer;

    @Before
    public void prepare() {
        customer = new Customer("Horst");
    }

    @Test
    public void getName() {
        assertEquals("Horst", customer.getName());
    }

    @Test
    public void statement() {
        assertTrue(customer.statement().startsWith("Rental Record for Horst"));
        assertTrue(customer.statement().endsWith(" frequent renter points"));
    }
}
