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
    private SeatPanel seatPanel;
    private ExistingCustomer_Panel existingCustomer_panel;
    private TicketPanel ticketPanel;
    private JTabbedPane tabPanel;
    private MovieTheaterGroup movieTheaterGroup;
    private JPanel buttonPanel;
    private NewCustomer_Panel newCustomer_Panel;
    private CM_Panel CM;

    public CinemaTicket_GUI() {
        CinemaTicket_GUI cinemaTicket_gui = this;
        // Initializing components
        tabPanel = new JTabbedPane();
        movieTheaterGroup = new MovieTheaterGroup("Cinemaximum");
        newCustomer = new JButton("New Customer");
        existingCustomer = new JButton("Existing Customer");
        buttonPanel = new JPanel();
        existingCustomer_panel = new ExistingCustomer_Panel(movieTheaterGroup,cinemaTicket_gui);
        newCustomer_Panel = new NewCustomer_Panel(movieTheaterGroup,cinemaTicket_gui);
        mainPanel = new JPanel();
        ticketPanel = new TicketPanel(movieTheaterGroup,cinemaTicket_gui);
        CM = new CM_Panel(movieTheaterGroup);

        // Adding components to the buttonPanel
        buttonPanel.add(newCustomer);
        buttonPanel.add(existingCustomer);

        // Adding actionListener to the newCustomer panel
        newCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    newCustomer_Panel = new NewCustomer_Panel(movieTheaterGroup,cinemaTicket_gui);
                    mainPanel.remove(buttonPanel);
                    mainPanel.add(newCustomer_Panel);
                    mainPanel.repaint();
                    mainPanel.revalidate();
                }
            }
        });

        // Adding actionListener to the existingCustomer button
        existingCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    existingCustomer_panel = new ExistingCustomer_Panel(movieTheaterGroup,cinemaTicket_gui);
                    mainPanel.remove(buttonPanel);
                    mainPanel.add(existingCustomer_panel);
                    mainPanel.repaint();
                    mainPanel.revalidate();
                }
            }
        });

        // Setting size
        tabPanel.setPreferredSize(new Dimension(main.WIDTH-20,main.HEIGHT-50));

        // Adding tab for buying ticket and displaying Movie theater group information
        tabPanel.addTab("Ticket",mainPanel);
        tabPanel.addTab("Cinemaximum",CM);

        // Adding components to the mainPanel
        mainPanel.add(buttonPanel);

        // Adding to the this panel
        add(tabPanel);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public SeatPanel getSeatPanel() {
        return seatPanel;
    }

    public ExistingCustomer_Panel getExistingCustomer_panel() {
        return existingCustomer_panel;
    }

    public TicketPanel getTicketPanel() {
        return ticketPanel;
    }

    public NewCustomer_Panel getNewCustomer_Panel() {
        return newCustomer_Panel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setSeatPanel(SeatPanel seatPanel) {
        this.seatPanel = seatPanel;
    }

    public void setExistingCustomer_panel(ExistingCustomer_Panel existingCustomer_panel) {
        this.existingCustomer_panel = existingCustomer_panel;
    }

    public void setTicketPanel(TicketPanel ticketPanel) {
        this.ticketPanel = ticketPanel;
    }

    public void setNewCustomer_Panel(NewCustomer_Panel newCustomer_Panel) {
        this.newCustomer_Panel = newCustomer_Panel;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }
}
