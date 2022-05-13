package classes;
import java.lang.*;
import java.util.*;

public class Customer {
    private String name;
    private Vector rentals = new Vector();
    public Customer (String newname){
        name = newname;
    };

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    };

    public String getName (){
        return name;
    };

    public String statement() {
        String statement = getRentalRecordHeader();
        statement += getRentalRecord();
        return statement;
    }

    private String getRentalRecord() {
        String rentalRecord = "";
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental rental = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            thisAmount = rental.getAmountFor();
            frequentRenterPoints = addFrequentRenterPoints(frequentRenterPoints);
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
                frequentRenterPoints = addFrequentRenterPoints(frequentRenterPoints);
            //show figures for this rental
            rentalRecord = "\t" + rental.getMovie().getTitle()+ "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        rentalRecord += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        rentalRecord += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
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
    