package Model;

public class Movie {
    private String nameOfMovie;
    private String genre;
    private Branch branch;
    private boolean seat[][];

    public Movie(String nameOfMovie, String genre, Branch branch) {
        this.nameOfMovie = nameOfMovie;
        this.genre = genre;
        this.branch = branch;
        addingToBranch(this,branch);
        seat = new boolean[5][5];
        initSeat();
    }

    public void initSeat() {
        for (int y = 0; y < seat.length; y++) {
            for (int x = 0; x < seat[0].length; x++) {
                seat[y][x] = false;
            }
        }
    }

    public void addingToBranch(Movie movie, Branch branch) {
        branch.addMovie(movie);
    }

    public String toString() {
        return nameOfMovie;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNameOfMovie() {
        return nameOfMovie;
    }

    public String getGenre() {
        return genre;
    }

    public boolean[][] getSeat() {
        return seat;
    }
}
