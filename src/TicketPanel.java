import Model.Ticket;

import javax.swing.*;
import java.awt.*;

public class TicketPanel extends JPanel {
    private JPanel seatPanel;
    private JPanel ticketPanel;

    public TicketPanel() {
        // Initializing  hte components
        seatPanel = new JPanel();
        ticketPanel = new JPanel();

        // Creating layout for seat panel
        seatPanel.setLayout(new GridBagLayout());
    }
}
