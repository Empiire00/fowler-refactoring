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
        movie1 = new Movie("Inception", 1);
        movie2 = new Movie("Matrix", 1);
    }

    @Test
    public void getTitle(){
        assertEquals("Inception",movie1.getTitle());
    }
    @Test
    public void getPriceCode(){
        assertEquals(1, movie1.getPriceCode());
        assertEquals(MoviePriceCategory.NEW_RELEASE, movie1.getPriceCategory());
    }
    @Test
    public void setPriceCode() {
        movie2.setPriceCode(0);
        assertEquals(0, movie2.getPriceCode());
    }
}
