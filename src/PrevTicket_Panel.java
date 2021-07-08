import Model.Customer;
import Model.MovieTheaterGroup;
import Model.Ticket;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PrevTicket_Panel extends JPanel {
    private JTable ticketInfo;
    private Customer customer;
    private JLabel noPrevTicket;
    private JScrollPane sp;

    public PrevTicket_Panel(MovieTheaterGroup movieTheaterGroup, ExistingCustomer_Panel existingCustomer_panel) {
        // Initializing the components
        noPrevTicket = new JLabel("There is no Previous Ticket!");
        ticketInfo = new JTable();
        customer = movieTheaterGroup.getCustomer();
        sp = new JScrollPane(ticketInfo);




        // Initialize according to customer
        if (movieTheaterGroup.getCustomer().getPrevTickets().size() < 1) {
            // Setting color for noPrevTicket (JLabel)
            noPrevTicket.setForeground(Color.RED);
            add(noPrevTicket);
        }
        else {
            // Column names for ticketInfo
            String[] columnNames = {"Movie","Price","Branch","Number of Adult","Number of Child"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);

            DefaultTableCellRenderer rendar = new DefaultTableCellRenderer();
            rendar.setHorizontalAlignment(JLabel.CENTER);

            // Setting size ticket infoo
            sp.setPreferredSize(new Dimension(main.WIDTH-100,main.HEIGHT-150));

            for (Ticket ticket : customer.getPrevTickets()) {
                String movie = ticket.getMovie().getNameOfMovie();
                String price = String.format("%s",ticket.getTotalPrice());
                String branch = ticket.getBranch().getNameOfBranch();
                String numOfAdult = String.format("%s",ticket.getAdultCount());
                String numOfChild = String.format("%s",ticket.getChildrenCount());

                // String array for the information of ticket
                String[] str = {movie,price,branch,numOfAdult,numOfChild};

                // Add these information to the ticketInfo
                tableModel.addRow(str);
            }


            ticketInfo.setModel(tableModel);
            for (int i = 0; i < 5; i++) {
                ticketInfo.getColumnModel().getColumn(i).setCellRenderer(rendar);
            }

            // Adding ticketInfo to the this panel
            add(sp);
        }

    }
}
