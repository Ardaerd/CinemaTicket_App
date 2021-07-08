import Model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TicketPanel extends JPanel {
    private ImageIcon wrong;
    private ImageIcon correct;
    private PrevTicket_Panel prevTicketPanel;
    private JPanel buttonPanel;
    private JPanel mainPanel;
    private JPanel ticketPanel;
    private JButton buyTicket;
    private JButton displayPrev;
    private GridBagConstraints gbc;
    private JLabel movieLabel;
    private JLabel adultLabel;
    private JLabel childLabel;
    private JLabel branchLabel;
    private JComboBox<Movie> selectMovie;
    private JComboBox<Branch> selectBranch;
    private JSpinner adultCounter;
    private JSpinner childCounter;
    private JButton buyButton;
    private boolean prevTicketClicked;
    private boolean buyTicketClicked;
    private Customer customer;
    private ExistingCustomer_Panel existingCustomer_panel;

    public TicketPanel(MovieTheaterGroup movieTheaterGroup,CinemaTicket_GUI cinemaTicket_gui) {
        // Initializing the components
        wrong = new ImageIcon("src/Pic/wrong.png");
        correct = new ImageIcon("src/Pic/check.png");
        prevTicketClicked = false;
        buyTicketClicked = false;
        prevTicketPanel = new PrevTicket_Panel(movieTheaterGroup, existingCustomer_panel);
        buttonPanel = new JPanel();
        mainPanel = new JPanel();
        ticketPanel = new JPanel();
        buyTicket = new JButton("Buy Ticket");
        displayPrev = new JButton("Display Previous Ticket");
        buyButton = new JButton("Buy Ticket");
        movieLabel = new JLabel("Select a Movie:");
        branchLabel = new JLabel("Select a Branch:");
        adultLabel = new JLabel("# Adults:");
        childLabel = new JLabel("# Children:");
        selectMovie = new JComboBox<Movie>();
        selectBranch = new JComboBox<Branch>();
        adultCounter = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        childCounter = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        gbc = new GridBagConstraints();

        // Adding branches to teh selectBranch (JComboBox)
        for (Branch branch : movieTheaterGroup.getListOfBranch()) {
                selectBranch.addItem(branch);
        }

        selectBranch.setSelectedIndex(-1);


        selectBranch.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Branch branch = (Branch) e.getItem();

                    // Adding movies to the selectMovie (JComboBox)
                    selectMovie.removeAllItems();
                    for (Movie movie : branch.getListOfMovie()) {
                        selectMovie.addItem(movie);
                    }
                    selectMovie.setSelectedIndex(-1);
                }
            }
        });

        // Setting size
        buyTicket.setPreferredSize(new Dimension(170,30));
        displayPrev.setPreferredSize(new Dimension(230,30));
        selectMovie.setPreferredSize(new Dimension(150,25));
        selectBranch.setPreferredSize(new Dimension(150,25));

        // Setting Layout
        setLayout(new BorderLayout());
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,15,0));
        ticketPanel.setLayout(new GridBagLayout());

        // Setting places for the component of the ticketPanel
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        gbc.insets = new Insets(200,50,10,50);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        addGBTicket(branchLabel,0,0);

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        addGBTicket(selectBranch,1,0);

        gbc.insets = new Insets(10,50,10,50);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        addGBTicket(movieLabel,0,1);

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        addGBTicket(selectMovie,1,1);

        gbc.ipadx = 10;
        gbc.ipady = 7;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        addGBTicket(adultLabel,0,2);

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        addGBTicket(adultCounter,1,2);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        addGBTicket(childLabel,0,3);

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        addGBTicket(childCounter,1,3);

        gbc.insets = new Insets(30,50,10,50);
        gbc.gridwidth = 2;
        gbc.ipadx = 70;
        gbc.ipady = 8;
        gbc.anchor = GridBagConstraints.CENTER;
        addGBTicket(buyButton,0,4);

        // Setting places for the component of the prevTicketPanel



        // Adding components to the button panel
        buttonPanel.add(displayPrev);
        buttonPanel.add(buyTicket);

        // Adding actionListener to the buyTicket button for displaying ticketPanel
        buyTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    // Adding panels to the mainPanel
                    if (prevTicketClicked) {
                        mainPanel.remove(prevTicketPanel);
                        prevTicketClicked = false;
                    }
                    buyTicketClicked = true;
                    mainPanel.add(ticketPanel);
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            }
        });

        // Adding actionListener to the previous ticket button for displaying previous ticket
        displayPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    // Adding panels to the mainPanel
                    if (buyTicketClicked) {
                        mainPanel.remove(ticketPanel);
                        buyTicketClicked = false;
                    }
                    prevTicketClicked = true;
                    mainPanel.add(prevTicketPanel);
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            }
        });

        // Adding actionListener to the buyButton for buying a ticket
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    if (selectBranch.getSelectedIndex() == -1) {
                        JOptionPane.showMessageDialog(null,"You have to fill Branch section!","Empty Branch",JOptionPane.QUESTION_MESSAGE,wrong);
                    } else if (selectMovie.getSelectedIndex() == -1) {
                        JOptionPane.showMessageDialog(null,"You have to fill Movie section!","Empty Movie",JOptionPane.QUESTION_MESSAGE,wrong);
                    } else if (((Integer) childCounter.getValue()) == 0 && ((Integer) adultCounter.getValue() == 0)) {
                        JOptionPane.showMessageDialog(null,"You have to increment person section!","Zero Ticket",JOptionPane.QUESTION_MESSAGE,wrong);
                    } else {
                        customer = NewCustomer_Panel.customer;
                        customer.buyTicket((Branch) selectBranch.getSelectedItem(),(Movie) selectMovie.getSelectedItem(),(Integer) adultCounter.getValue(), (Integer) childCounter.getValue());
                        String str = "The payment is successful!\n" +
                                "Ticket price is " + customer.getPrevTickets().get(customer.getPrevTickets().size()-1).getTotalPrice() + " TL";
                        JOptionPane.showMessageDialog(null,str,"Buying Ticket",JOptionPane.QUESTION_MESSAGE,correct);

                        cinemaTicket_gui.setSeatPanel(new SeatPanel(movieTheaterGroup,cinemaTicket_gui));
                        CinemaTicket_GUI.mainPanel.remove(cinemaTicket_gui.getTicketPanel());
                        CinemaTicket_GUI.mainPanel.add(cinemaTicket_gui.getSeatPanel());
                        CinemaTicket_GUI.mainPanel.revalidate();
                        CinemaTicket_GUI.mainPanel.repaint();
                    }
                }
            }
        });

        // Adding components to the this panel
        add(buttonPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.SOUTH);
    }

    public void addGBTicket(Component comp, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        ticketPanel.add(comp,gbc);
    }

    public JComboBox<Movie> getSelectMovie() {
        return selectMovie;
    }

    public Customer getCustomer() {
        return customer;
    }
}
