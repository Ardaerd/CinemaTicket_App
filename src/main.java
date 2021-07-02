import javax.swing.*;

public class main {
    public static int WIDTH = 800;
    public static int HEIGHT = 600;

    public static void main(String[] args) {
        JFrame frame = new JFrame("CinemaTicket_App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocation(550,115);
        frame.add(new CinemaTicket_GUI());
        frame.setVisible(true);
    }
}
