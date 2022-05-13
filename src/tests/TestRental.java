package tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import classes.*;


public class TestRental {
    private Rental rental;
    private Movie movie;
    @Before
    public void prepare(){
        movie = new Movie("Test Movie", 10);
        rental = new Rental(movie,5);
    }
    @Test
    public void getDaysRented() {
        assertEquals(5, rental.getDaysRented());
    }

    @Test
    public void getMovie() {
        assertEquals(movie, rental.getMovie());
    }
}
