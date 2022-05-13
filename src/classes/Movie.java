package classes;

public class Movie {
    private final String title;
    private int priceCode;
    private MoviePriceCategory priceCategory;

    public Movie(String newTitle, int newPriceCode) {
        title = newTitle;
        priceCode = newPriceCode;
        priceCategory = MoviePriceCategory.values()[newPriceCode];
    }

    public int getPriceCode() {
        return priceCode;
    }
    public MoviePriceCategory getPriceCategory(){
        return priceCategory;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
        priceCategory = MoviePriceCategory.values()[priceCode];
    }

    public String getTitle (){
        return title;
    }
}