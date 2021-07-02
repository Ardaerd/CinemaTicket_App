import Model.Branch;
import Model.MovieTheaterGroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CinemaTicket_GUI extends JPanel {
    private JButton newCustomer;
    private JButton existingCustomer;
    private TicketPanel ticketPanel;
    private JTabbedPane tabPanel;
    private MovieTheaterGroup movieTheaterGroup;
    private JPanel buttonPanel;
    private NewCustomer_Panel newCustomer_Panel;

    public CinemaTicket_GUI() {
        // Initializing components
        tabPanel = new JTabbedPane();
        movieTheaterGroup = new MovieTheaterGroup("Cinemaximum");
        ticketPanel = new TicketPanel();
        newCustomer = new JButton("New Customer");
        existingCustomer = new JButton("Existing Customer");
        buttonPanel = new JPanel();
        newCustomer_Panel = new NewCustomer_Panel(movieTheaterGroup);

        // Adding components to the buttonPanel
        buttonPanel.add(newCustomer);
        buttonPanel.add(existingCustomer);

        // Adding actionListener to the components of the buttonPanel
        newCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    tabPanel.remove(buttonPanel);
                    tabPanel.addTab("Ticket",newCustomer_Panel);
                    tabPanel.repaint();
                    tabPanel.revalidate();
                }
            }
        });

        // Setting size
        tabPanel.setPreferredSize(new Dimension(main.WIDTH-20,main.HEIGHT-50));

        // Adding branch to the tab from the branch class
        tabPanel.addTab("Ticket",buttonPanel);

        // Adding components to the this panel
        add(tabPanel);
    }
}
