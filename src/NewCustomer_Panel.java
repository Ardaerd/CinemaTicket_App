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

    public NewCustomer_Panel(MovieTheaterGroup movieTheaterGroup) {
        // Initializing components of the newCustomer_Panel
        addCustomer_Panel = new JPanel();
        firstNameLabel = new JLabel("First Name: ");
        lastNameLabel = new JLabel("Last Name: ");
        firstName = new JTextField();
        lastName = new JTextField();
        addButton = new JButton("Add");
        gbc = new GridBagConstraints();
        this.movieTheaterGroup = movieTheaterGroup;

        // Setting layout for this panel
        addCustomer_Panel.setLayout(new GridBagLayout());

        // Setting place for the components of the newCustomer_Panel
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        gbc.insets = new Insets(10,10,10,10);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        addGB(firstNameLabel,0,0);

        gbc.ipadx = 190;
        gbc.ipady = 5;

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        addGB(firstName,1,0);

        gbc.insets = new Insets(10,10,25,10);
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
                    customer = new Customer(firstName.getText(),lastName.getText());
                    movieTheaterGroup.addCustomer(customer);
                    JOptionPane.showMessageDialog(null,firstName.getText().toUpperCase() + " " + lastName.getText().toUpperCase() + " is added", "Customer",JOptionPane.INFORMATION_MESSAGE);
                    CinemaTicket_GUI.mainPanel.remove(CinemaTicket_GUI.newCustomer_Panel);
                    CinemaTicket_GUI.mainPanel.add(CinemaTicket_GUI.ticketPanel);
                    CinemaTicket_GUI.mainPanel.revalidate();
                    CinemaTicket_GUI.mainPanel.repaint();
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
