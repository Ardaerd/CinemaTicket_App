package Model;

import Model.Movie;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ticket {
    private int adultCount;
    private int childrenCount;
    private Movie movie;
    private Branch branch;
    private double totalPrice;
    private boolean seat[][];
    private Customer customer;

    public Ticket(Movie movie,Branch branch,Customer customer) {
        this.branch = branch;
        this.movie = movie;
        this.customer = customer;
        seat = new boolean[5][5];
    }

    public String toString() {
        String str = "Customer: " + customer.getFirstName() + " " + customer.getLastName() + "\n" +
                "Ticket for " + movie.getNameOfMovie() + " (" + movie.getGenre() + ")\n" +
                adultCount + " adults and " + childrenCount + " children\n" +
                "Total price is " + totalPrice + " TL\n";

        return  str;
    }

    public int getAdultCount() {
        return adultCount;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice() {
        totalPrice = adultCount * 20 + childrenCount * 10;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }

    public void setSeat(boolean[][] seat) {
        this.seat = seat;
    }

    public boolean[][] getSeat() {
        return seat;
    }

    public Branch getBranch() {
        return branch;
    }

    public Customer getCustomer() {
        return customer;
    }
}
