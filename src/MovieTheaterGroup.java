import java.util.ArrayList;

public class MovieTheaterGroup {
    // This class represent a movie theater group like Cinemaximum, Cinecity
    private String nameOfGroup;
    private ArrayList<Branch> listOfBranch;
    private ArrayList<Customer> listOfCustomer;

    public MovieTheaterGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
        listOfBranch = new ArrayList<>();
        listOfCustomer = new ArrayList<>();
    }

    public void calculateBranchRevenue(Branch branch, Movie movie) {
        double totalRevenue = 0.0;
        ArrayList<Ticket> ticketList = branch.getPrevTicket();

        for (Ticket ticket : ticketList) {
            if (ticket.getMovie() == movie) {
                totalRevenue += ticket.getTotalPrice();
            }
        }

        System.out.println("Total revenue of " + branch.getNameOfBranch() + " from movie " + movie.getNameOfMovie() +
                " is " + totalRevenue + " TL");
    }

    public void displayBranches4Movie(Movie movie) {
        if (checkMovie(movie)) {
            System.out.println(movie.getNameOfMovie() + " is playing in following branches: ");
            int i = 0;

            for (Branch branch : listOfBranch) {
                if (branch.getListOfMovie().contains(movie)) {
                    i++;
                    System.out.println(i + ". " + branch.getNameOfBranch());
                }
            }
        }
        else
            System.out.println(movie.getNameOfMovie() + " is not playing in any branch!");
    }

    public boolean checkMovie(Movie movie) {

        for (Branch branch : listOfBranch) {
            if (branch.getListOfMovie().contains(movie)) {
                return true;
            }
        }

        return false;
    }

    public void addCustomer(Customer customer) {
        listOfCustomer.add(customer);
    }

    public void openBranch(String str) {
        Branch newBranch = new Branch(str);

        listOfBranch.add(newBranch);
    }

    public void listBranches() {
        System.out.println("Branches of the Cinemaximum:");
        for (Branch branch : listOfBranch) {
            System.out.println((listOfBranch.indexOf(branch)+1) + ". " + branch.getNameOfBranch());
        }
    }
}
