import Model.Customer;
import Model.MovieTheaterGroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ExistingCustomer_Panel extends JPanel {
    private JComboBox<Customer> selectCustomer;
    public static Customer customer;
    private JButton buyTicket;
    private GridBagConstraints gbc;
    private ImageIcon wrongUser;

    public ExistingCustomer_Panel(MovieTheaterGroup movieTheaterGroup) {
        // Initializing the components
        selectCustomer = new JComboBox<>();
        buyTicket = new JButton("Buy Ticket");
        gbc = new GridBagConstraints();
        wrongUser = new ImageIcon("src/Pic/authentication.png");

        // Setting Layout
        setLayout(new GridBagLayout());

        // Adding customer to the existingCustomers (JComboBox)
        for (Customer customer : movieTheaterGroup.getListOfCustomer()) {
            selectCustomer.addItem(customer);
        }

        // selectCustomer's initial display is made empty
        selectCustomer.setSelectedIndex(-1);

        // Setting size for the components
        selectCustomer.setPreferredSize(new Dimension(150,25));
        buyTicket.setPreferredSize(new Dimension(170,30));

        // Adding ItemListener to the selectCustomer
        selectCustomer.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Customer existingCustomer = (Customer) e.getItem();
                    customer = existingCustomer;
                }
            }
        });

        if (movieTheaterGroup.getListOfCustomer().size() < 1) {
            buyTicket.setPreferredSize(new Dimension(270,30));
            buyTicket.setText("Return The Customer Menu");
        }

        buyTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    // If there is no existing customer
                    if (movieTheaterGroup.getListOfCustomer().size() < 1) {
                        JOptionPane.showMessageDialog(null,"There is no existing customer", "Customer",JOptionPane.INFORMATION_MESSAGE,wrongUser);

                        CinemaTicket_GUI.mainPanel.remove(CinemaTicket_GUI.existingCustomer_panel);
                        CinemaTicket_GUI.mainPanel.add(CinemaTicket_GUI.buttonPanel);
                        CinemaTicket_GUI.mainPanel.repaint();
                        CinemaTicket_GUI.mainPanel.revalidate();
                    }

                    // If there is an existing customer
                    else {
                        CinemaTicket_GUI.ticketPanel = new TicketPanel(movieTheaterGroup);

                        CinemaTicket_GUI.mainPanel.remove(CinemaTicket_GUI.existingCustomer_panel);
                        CinemaTicket_GUI.mainPanel.add(CinemaTicket_GUI.ticketPanel);
                        CinemaTicket_GUI.mainPanel.repaint();
                        CinemaTicket_GUI.mainPanel.revalidate();
                    }
                }
            }
        });

        // Setting places and adding to the this panel for the components
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        gbc.insets = new Insets(50,0,90,0);

        gbc.anchor = GridBagConstraints.CENTER;
        addGB(selectCustomer,0,0);

        gbc.anchor = GridBagConstraints.CENTER;
        addGB(buyTicket,0,1);

    }

    // Using GridBoxLayout easily
    public void addGB(Component comp, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        add(comp,gbc);
    }
}
