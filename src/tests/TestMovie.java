package tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import classes.*;



public class TestMovie {
    private Movie movie1;
    private Movie movie2;
    @Before
    public void prepare(){
        movie1 = new Movie("Inception", 15);
        movie2 = new Movie("Matrix", 10);
    }

    @Test
    public void getTitle(){
        assertEquals("Inception",movie1.getTitle());
    }
    @Test
    public void getPriceCode(){
        assertEquals(15, movie1.getPriceCode());
    }
    @Test
    public void setPriceCode() {
        movie2.setPriceCode(18);
        assertEquals(18, movie2.getPriceCode());
    }
}
