package Model;

import Model.Branch;

import java.util.ArrayList;
import java.util.Collection;

public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList<Ticket> prevTickets;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        prevTickets = new ArrayList<>();
    }

    public void buyTicket(Branch branch, Movie movie, int adultCount, int childrenCount) {
        Ticket ticket = new Ticket(movie,branch,this);

        ticket.setAdultCount(adultCount);
        ticket.setChildrenCount(childrenCount);
        ticket.setTotalPrice();

        branch.addTicket(ticket);
        prevTickets.add(ticket);
        System.out.println(ticket);
    }

    public String listTickets() {
        String str = "";

        for (Ticket ticket : prevTickets) {
            str += ticket.toString();
        }

        return str;
    }

    public String toString() {
        return firstName.substring(0,1).toUpperCase() + firstName.substring(1) + " " + lastName.substring(0,1).toUpperCase() + lastName.substring(1).toUpperCase();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Ticket> getPrevTickets() {
        return prevTickets;
    }
}
