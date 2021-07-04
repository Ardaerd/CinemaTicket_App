package Model;

public class Movie {
    private String nameOfMovie;
    private String genre;

    public Movie(String nameOfMovie, String genre) {
        this.nameOfMovie = nameOfMovie;
        this.genre = genre;
    }

    public String toString() {
        return nameOfMovie;
    }

    public String getNameOfMovie() {
        return nameOfMovie;
    }

    public String getGenre() {
        return genre;
    }
}
