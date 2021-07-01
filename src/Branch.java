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

    public void listMovies() {

        for (Movie movie : listOfMovie) {
            System.out.println((listOfMovie.indexOf(movie)+1) + ". " + movie.getNameOfMovie() + " (" + movie.getGenre() + ")");
        }

    }

    public void addTicket(Ticket ticket) {
        prevTicket.add(ticket);
    }

    public void addMovie(Movie movie) {
        listOfMovie.add(movie);
    }

    public void removeMovie(Movie movie) {
        listOfMovie.remove(movie);
    }

    public String getNameOfBranch() {
        return nameOfBranch;
    }

    public ArrayList<Movie> getListOfMovie() {
        return listOfMovie;
    }

    public ArrayList<Ticket> getPrevTicket() {
        return prevTicket;
    }
}

