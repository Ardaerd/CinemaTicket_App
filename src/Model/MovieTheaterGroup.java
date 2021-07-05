package Model;

import java.util.ArrayList;

public class MovieTheaterGroup {
    // This class represent a movie theater group like Cinemaximum, Cinecity
    private String nameOfGroup;
    private ArrayList<Branch> listOfBranch;
    private ArrayList<Customer> listOfCustomer;
    private boolean seat[][];

    public MovieTheaterGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
        listOfBranch = new ArrayList<>();
        listOfCustomer = new ArrayList<>();
        seat = new boolean[5][5];
        initBranches();
        initSeat();
        initMovie();
        checkSeat();
    }

    public void initSeat() {
        for (int y = 0; y < seat.length; y++) {
            for (int x = 0; x < seat[0].length; x++) {
                seat[y][x] = false;
            }
        }
    }

    public void checkSeat() {
        for (Customer customer : listOfCustomer) {
            for (Ticket ticket : customer.getPrevTickets()) {
                for (int y = 0; y < ticket.getSeat().length; y++) {
                    for (int x = 0; x < ticket.getSeat()[0].length; x++) {
                        if (ticket.getSeat()[y][x] && !seat[y][x]) {
                            seat[y][x] = true;
                        }
                    }
                }
            }
        }
    }

    public void initBranches() {
        openBranch("Ataşehir");
        openBranch("Taksim");
        openBranch("Levent");
    }

    public void initMovie() {
        listOfBranch.get(0).addMovie(new Movie("Arrival","Sci-Fi"));
        listOfBranch.get(0).addMovie(new Movie("Rogue One","Sci-Fi"));
        listOfBranch.get(0).addMovie(new Movie("Moana","Animation"));
        listOfBranch.get(1).addMovie(new Movie("Rogue One","Sci-Fi"));
        listOfBranch.get(2).addMovie(new Movie("Moana","Animation"));
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

    public Branch openBranch(String str) {
        Branch newBranch = new Branch(str);
        listOfBranch.add(newBranch);


        return newBranch;
    }

    public void listBranches() {
        System.out.println("Branches of the Cinemaximum:");
        for (Branch branch : listOfBranch) {
            System.out.println((listOfBranch.indexOf(branch)+1) + ". " + branch.getNameOfBranch());
        }
    }

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public ArrayList<Branch> getListOfBranch() {
        return listOfBranch;
    }

    public ArrayList<Customer> getListOfCustomer() {
        return listOfCustomer;
    }

    public boolean[][] getSeat() {
        return seat;
    }
}
