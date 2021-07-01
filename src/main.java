public class main {
    public static void main(String[] args) {
        MovieTheaterGroup CM = new MovieTheaterGroup("Cinemaximum");
        // Console output: No output

        Branch Atasehir = CM.openBranch("Cinemaximum Atasehir");
        Branch Taksim = CM.openBranch("Cinemaximum Taksim");
        Branch Levent = CM.openBranch("Cinemaximum Levent");
        // Console output: No output

        CM.listBranches();
        /*
          Branches of the Cinemaximum:
          1. Cinemaximum Atasehir
          2. Cinemaximum Taksim
          3. Cinemaximum Levent
         */

        Movie Arrival = new Movie("Arrival", "Sci-Fi");
        Movie RougeOne = new Movie("Rogue One","Sci-Fi");
        Movie Moana = new Movie("Moana", "Animation");
        // Console output: No output

        Levent.addMovie(Arrival);
        Levent.addMovie(Moana);
        // Console output: No output

        Levent.listMovies();
        /*
        Movies playing at branch Cinemaximum Levent
        1. Arrival (Sci-Fi)
        2. Moana (Animation)
         */

        Taksim.addMovie(Arrival);
        Taksim.addMovie(RougeOne);
        Taksim.addMovie(Moana);
        // Console output: No output

        Taksim.listMovies();
        /*
        Movies playing at branch Cinemaximum Taksim:
        1. Arrival (Sci-Fi)
        2. Rogue One (Sci-Fi)
        3. Moana (Animation)
         */

        Taksim.removeMovie(RougeOne);
        // Console output: No output

        Taksim.listMovies();

        CM.displayBranches4Movie(Arrival);

        CM.displayBranches4Movie(RougeOne);

        Customer Brown = new Customer("Bob","Brown");
        CM.addCustomer(Brown);
        Customer Ryan = new Customer("Jack","Ryan");
        CM.addCustomer(Ryan);
        Customer Smith = new Customer("Jane","Smith");
        CM.addCustomer(Smith);

        Brown.buyTicket(Levent,Moana,2,2);
        Ryan.buyTicket(Levent, Arrival, 2, 0);
        Smith.buyTicket(Levent, Arrival, 3, 0);
        Ryan.buyTicket(Taksim, Arrival, 4, 0);

        CM.calculateBranchRevenue(Levent,Arrival);
        CM.calculateBranchRevenue(Taksim,Moana);
    }
}
