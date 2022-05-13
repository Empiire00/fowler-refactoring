package classes;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private int priceCode;
    private MoviePriceCategory priceCategory;

    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        priceCode = newpriceCode;
        priceCategory = MoviePriceCategory.values()[newpriceCode];
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
    };
}