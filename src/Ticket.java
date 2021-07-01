public class Ticket {
    private int adultCount;
    private int childrenCount;
    private Movie movie;
    private double totalPrice;

    public Ticket(Movie movie) {
        this.movie = movie;
        totalPrice = adultCount * 20 + childrenCount * 10;
    }

    public String toString() {
        String str = "Total price is " + totalPrice + " TL\n" +
                "Ticket for " + movie.getNameOfMovie() + " (" + movie.getGenre() + ")\n" +
                adultCount + " adults and " + childrenCount + " children\n";
        
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

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }
}
