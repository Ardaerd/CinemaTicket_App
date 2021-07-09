import Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DisplayTickets_Panel extends JPanel {
    private JTable allTickets;
    private JScrollPane sp;
    private JLabel numOfTicketLabel;
    private JPanel counterLabel;

    public DisplayTickets_Panel(MovieTheaterGroup movieTheaterGroup) {
        // Initializing the components
        allTickets = new JTable();
        sp = new JScrollPane(allTickets);
        numOfTicketLabel = new JLabel();
        counterLabel = new JPanel();

        // Number of ticket
        int numOfTicket = 0;

        // Setting layout
        setLayout(new BorderLayout());
        counterLabel.setLayout(new BorderLayout());

        // String array for the information of ticket
        String[] columnNames = {"Customer Name","Branch","Movie","Total Price"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);

        // Setting text center
        DefaultTableCellRenderer rendar = new DefaultTableCellRenderer();
        rendar.setHorizontalAlignment(JLabel.CENTER);

        for (Branch branch : movieTheaterGroup.getListOfBranch()) {
            String nameOfBranch = branch.getNameOfBranch();
            System.out.println(nameOfBranch);

            for (Ticket ticket : branch.getPrevTicket()) {
                numOfTicket++;
                String nameOfMovie = ticket.getMovie().getNameOfMovie();
                String nameOfCustomer = ticket.getCustomer().getFirstName().substring(0,1).toUpperCase() + ticket.getCustomer().getFirstName().substring(1).toLowerCase()  + " " + ticket.getCustomer().getLastName().substring(0,1).toUpperCase() + ticket.getCustomer().getLastName().substring(1).toLowerCase() ;
                String totalPrice = String.format("%s TL",ticket.getTotalPrice());

                // String array for the information of ticket
                String[] str = {nameOfCustomer,nameOfBranch,nameOfMovie,totalPrice};

                // Add these information to the allTickets
                tableModel.addRow(str);
            }
        }

        allTickets.setModel(tableModel);
        for (int i = 0; i < 4; i++) {
            allTickets.getColumnModel().getColumn(i).setCellRenderer(rendar);
        }

        // Setting text for the numOfTickets
        numOfTicketLabel.setText("Number of Tickets: " + numOfTicket);

        //Adding to counterLabel panel
        counterLabel.add(numOfTicketLabel,BorderLayout.WEST);

        // Adding allTickets to this panel
        add(counterLabel,BorderLayout.NORTH);
        add(sp,BorderLayout.CENTER);
    }
}
