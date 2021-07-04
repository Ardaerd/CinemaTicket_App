import Model.MovieTheaterGroup;
import Model.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SeatPanel extends JPanel {
    private JPanel seatPanel;
    private JPanel screenPanel;
    private JPanel topPanel;
    private GridBagConstraints gbc;
    private ImageIcon seat;
    private ImageIcon selectedSeat;

    public SeatPanel(MovieTheaterGroup movieTheaterGroup) {
        // Initializing  the components
        seatPanel = new JPanel();
        topPanel = new JPanel();
        screenPanel = new JPanel();
        gbc = new GridBagConstraints();
        seat = new ImageIcon("src/Pic/seat.png");
        selectedSeat = new ImageIcon("src/Pic/seat (1).png");

        // Setting background color
        topPanel.setBackground(new Color(58, 61, 82));
        seatPanel.setBackground(new Color(58, 61, 82));

        // Creating layout
        seatPanel.setLayout(new GridBagLayout());
        topPanel.setLayout(new GridBagLayout());
        setLayout(new BorderLayout());

        // displaying screen
        screenPanel.setBackground(Color.WHITE);

        // Setting place for the screenPanel
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        gbc.insets = new Insets(5,10,0,10);

        gbc.ipadx = 400;
        gbc.ipady = 120;
        gbc.anchor = GridBagConstraints.CENTER;
        addGBTopPanel(screenPanel,0,0);

        addGBTopPanel(seatPanel,0,1);

        // Setting place for the seatPanel
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        gbc.insets = new Insets(10,30,15,30);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        for (int y = 0; y < movieTheaterGroup.getSeat().length; y++) {
            for (int x = 0; x < movieTheaterGroup.getSeat()[0].length; x++) {
                JLabel seatLabel = new JLabel();
                seatLabel.setIcon(seat);

                if (movieTheaterGroup.getSeat()[y][x]) {
                    seatLabel.setIcon(selectedSeat);
                }

                if (!movieTheaterGroup.getSeat()[y][x]) {
                    seatLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            if (e.getSource() instanceof JLabel) {
                                JLabel label = (JLabel) e.getSource();
                                label.setIcon(selectedSeat);
                            }
                        }
                    });
                }

                JLabel seatX = new JLabel(String.valueOf(x+1));
                seatX.setForeground(Color.WHITE);
                addGBSeatPanel(seatX,x,movieTheaterGroup.getSeat().length);
                addGBSeatPanel(seatLabel,x,y);
            }
        }

        // Adding to the this panel
        add(topPanel,BorderLayout.CENTER);
    }

    // Adding to the seat panel
    public void addGBSeatPanel(Component comp, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        seatPanel.add(comp,gbc);
    }

    // Adding to the top panel
    public void addGBTopPanel(Component comp, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        topPanel.add(comp,gbc);
    }
}
