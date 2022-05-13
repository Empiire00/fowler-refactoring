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
            Rental each = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            thisAmount = amountFor(each);
            frequentRenterPoints = addFrequentRenterPoints(frequentRenterPoints);
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints = addFrequentRenterPoints(frequentRenterPoints);
            //show figures for this rental
            rentalRecord = "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(thisAmount) + "\n";
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

    private double amountFor(Rental each) {
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.getDaysRented() > 2)
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3)
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

}
    