import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList<Ticket> prevTickets;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        prevTickets = new ArrayList<>();
    }

    public void buyTicket (Branch branch, Movie movie, int adultCount, int childrenCount) {
        Ticket ticket = new Ticket(movie);

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
}
