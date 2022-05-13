package classes;
import java.lang.*;
import java.util.*;

public class Customer {
    private final String name;
    private final ArrayList<Rental> rentals = new ArrayList<>();
    public Customer (String newName){
        name = newName;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName (){
        return name;
    }

    public String statement() {
        String statement = getRentalRecordHeader();
        statement += getRentalRecord();
        return statement;
    }

    private String getRentalRecord() {
        String rentalRecord = "";
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        for (Rental value : rentals) {
            double thisAmount;
            //determine amounts for each line
            thisAmount = value.getAmountFor();
            frequentRenterPoints = addFrequentRenterPoints(frequentRenterPoints);
            // add bonus for a two-day new release rental
            if ((value.getMovie().getPriceCategory() == MoviePriceCategory.NEW_RELEASE) && value.getDaysRented() > 1)
                frequentRenterPoints = addFrequentRenterPoints(frequentRenterPoints);
            //show figures for this rental
            rentalRecord = "\t" + value.getMovie().getTitle() + "\t" + "\t" + value.getDaysRented() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        rentalRecord += "Amount owed is " + totalAmount + "\n";
        rentalRecord += "You earned " + frequentRenterPoints + " frequent renter points";
        return rentalRecord;
    }

    private String getRentalRecordHeader() {
        String header = "Rental Record for " + this.getName() + "\n";
        header += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
        return header;
    }

    private static int addFrequentRenterPoints(int frequentRenterPoints) {
        frequentRenterPoints++;
        return frequentRenterPoints;
    }

}
    