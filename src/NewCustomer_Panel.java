import Model.Customer;
import Model.MovieTheaterGroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewCustomer_Panel extends JPanel {
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JTextField firstName;
    private JTextField lastName;
    private JButton addButton;
    private GridBagConstraints gbc;
    private MovieTheaterGroup movieTheaterGroup;
    private JPanel addCustomer_Panel;
    public static Customer customer;
    private ImageIcon addUser;
    private ImageIcon wrongUser;

    public NewCustomer_Panel(MovieTheaterGroup movieTheaterGroup,CinemaTicket_GUI cinemaTicket_gui) {
        // Initializing components of the newCustomer_Panel
        addUser = new ImageIcon("src/Pic/add-user.png");
        wrongUser = new ImageIcon("src/Pic/authentication.png");
        addCustomer_Panel = new JPanel();
        firstNameLabel = new JLabel("First Name: ");
        lastNameLabel = new JLabel("Last Name: ");
        firstName = new JTextField(15);
        lastName = new JTextField(15);
        addButton = new JButton("Add");
        gbc = new GridBagConstraints();
        this.movieTheaterGroup = movieTheaterGroup;

        // Setting layout for this panel
        addCustomer_Panel.setLayout(new GridBagLayout());

        // Setting place for the components of the newCustomer_Panel
        gbc.weightx = 13.0;
        gbc.weighty = 13.0;

        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        gbc.insets = new Insets(10,25,10,25);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        addGB(firstNameLabel,0,0);

        gbc.ipady = 6;

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        addGB(firstName,1,0);

        gbc.insets = new Insets(10,25,25,25);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        addGB(lastNameLabel,0,1);

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        addGB(lastName,1,1);

        gbc.insets = new Insets(10,10,200,10);
        gbc.gridwidth = 2;
        gbc.ipadx = 250;
        gbc.ipady = 10;
        gbc.anchor = GridBagConstraints.CENTER;
        addGB(addButton,0,2);

        // Adding actionListeners to the add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {

                        if (firstName.getText().length()<1 || lastName.getText().length()<1) {
                            System.out.println(firstName.getText().length());
                            System.out.println(lastName.getText().length());
                            JOptionPane.showMessageDialog(null,"You have to fill the form!", "Customer",JOptionPane.INFORMATION_MESSAGE,wrongUser);

                            CinemaTicket_GUI.mainPanel.remove(cinemaTicket_gui.getNewCustomer_Panel());
                            cinemaTicket_gui.setNewCustomer_Panel(new NewCustomer_Panel(movieTheaterGroup,cinemaTicket_gui));
                            CinemaTicket_GUI.mainPanel.add(cinemaTicket_gui.getNewCustomer_Panel());

                        } else {
                            customer = new Customer(firstName.getText(),lastName.getText());

                            if (movieTheaterGroup.checkCustomer(customer)) {
                                movieTheaterGroup.setCustomer(customer);
                                movieTheaterGroup.addCustomer(customer);
                                JOptionPane.showMessageDialog(null,firstName.getText().substring(0,1).toUpperCase() + firstName.getText().substring(1) + " " + lastName.getText().substring(0,1).toUpperCase() + lastName.getText().substring(1) + " is added!", "Customer",JOptionPane.INFORMATION_MESSAGE,addUser);

                                cinemaTicket_gui.setTicketPanel(new TicketPanel(movieTheaterGroup,cinemaTicket_gui));
                                CinemaTicket_GUI.mainPanel.remove(cinemaTicket_gui.getNewCustomer_Panel());
                                CinemaTicket_GUI.mainPanel.add(cinemaTicket_gui.getTicketPanel());
                            } else {
                                JOptionPane.showMessageDialog(null,firstName.getText().substring(0,1).toUpperCase() + firstName.getText().substring(1) + " " + lastName.getText().substring(0,1).toUpperCase() + lastName.getText().substring(1) + " is already an existing customer!", "Customer",JOptionPane.INFORMATION_MESSAGE,wrongUser);

                                CinemaTicket_GUI.mainPanel.remove(cinemaTicket_gui.getNewCustomer_Panel());
                                CinemaTicket_GUI.mainPanel.add(cinemaTicket_gui.getButtonPanel());
                            }
                        }


                    CinemaTicket_GUI.mainPanel.repaint();
                    CinemaTicket_GUI.mainPanel.revalidate();
                }
            }
        });

        add(addCustomer_Panel);
    }

    // Creating function to using GridBagLayout easily
    public void addGB(Component comp, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        addCustomer_Panel.add(comp,gbc);
    }


}
