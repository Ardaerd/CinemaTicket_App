import java.util.ArrayList;

public class Branch {
    private String nameOfBranch;
    private ArrayList<Movie> listOfMovie;
    private ArrayList<Ticket> prevTicket;

    public Branch(String nameOfBranch) {
        this.nameOfBranch = nameOfBranch;
        listOfMovie = new ArrayList<>();
        prevTicket = new ArrayList<>();
    }
}