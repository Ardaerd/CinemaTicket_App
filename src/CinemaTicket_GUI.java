import Model.Branch;
import Model.MovieTheaterGroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CinemaTicket_GUI extends JPanel {
    private JButton newCustomer;
    private JButton existingCustomer;
    public static JPanel mainPanel;
    public static SeatPanel seatPanel;
    private JTabbedPane tabPanel;
    private MovieTheaterGroup movieTheaterGroup;
    private JPanel buttonPanel;
    public static NewCustomer_Panel newCustomer_Panel;

    public CinemaTicket_GUI() {
        // Initializing components
        tabPanel = new JTabbedPane();
        movieTheaterGroup = new MovieTheaterGroup("Cinemaximum");
        seatPanel = new SeatPanel(movieTheaterGroup);
        newCustomer = new JButton("New Customer");
        existingCustomer = new JButton("Existing Customer");
        buttonPanel = new JPanel();
        newCustomer_Panel = new NewCustomer_Panel(movieTheaterGroup);
        mainPanel = new JPanel();

        // Adding components to the buttonPanel
        buttonPanel.add(newCustomer);
        buttonPanel.add(existingCustomer);

        // Adding actionListener to the components of the buttonPanel
        newCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    mainPanel.remove(buttonPanel);
                    mainPanel.add(newCustomer_Panel);
                    mainPanel.repaint();
                    mainPanel.revalidate();
                }
            }
        });

        // Setting size
        tabPanel.setPreferredSize(new Dimension(main.WIDTH-20,main.HEIGHT-50));

        // Adding tab for buying ticket and displaying Movie theater group information
        tabPanel.addTab("Ticket",mainPanel);

        // Adding components to the mainPanel
        mainPanel.add(buttonPanel);

        // Adding to the this panel
        add(tabPanel);
    }
}
