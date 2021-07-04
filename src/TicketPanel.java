import Model.Branch;
import Model.Movie;
import Model.MovieTheaterGroup;
import Model.Ticket;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TicketPanel extends JPanel {
    private JPanel buttonPanel;
    private JPanel mainPanel;
    private JPanel ticketPanel;
    private JPanel prevTicketPanel;
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

    public TicketPanel(MovieTheaterGroup movieTheaterGroup) {
        // Initializing the components
        buttonPanel = new JPanel();
        mainPanel = new JPanel();
        ticketPanel = new JPanel();
        prevTicketPanel = new JPanel();
        buyTicket = new JButton("Buy Ticket");
        displayPrev = new JButton("Display Previous Ticket");
        movieLabel = new JLabel("Select a Movie:");
        branchLabel = new JLabel("Select a Branch:");
        adultLabel = new JLabel("# Adults:");
        childLabel = new JLabel("# Children");
        selectMovie = new JComboBox<>();
        selectBranch = new JComboBox<>();
        adultCounter = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        childCounter = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        gbc = new GridBagConstraints();

        // Adding branches to teh selectBranch (JComboBox)
        for (Branch branch : movieTheaterGroup.getListOfBranch()) {
                selectBranch.addItem(branch);
        }

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

                }
            }
        });

        // Setting size
        buyTicket.setPreferredSize(new Dimension(170,30));
        displayPrev.setPreferredSize(new Dimension(230,30));

        // Setting Layout
        setLayout(new BorderLayout());
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,15,0));
        ticketPanel.setLayout(new GridBagLayout());
        prevTicketPanel.setLayout(new GridBagLayout());

        // Setting places for the component of the ticketPanel
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        gbc.insets = new Insets(100,50,10,50);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        addGBTicket(branchLabel,0,0);

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        addGBTicket(selectBranch,1,0);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        addGBTicket(movieLabel,0,1);

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        addGBTicket(selectMovie,1,1);

        // Adding components to the button panel
        buttonPanel.add(displayPrev);
        buttonPanel.add(buyTicket);

        // Adding panels to the mainPanel
        mainPanel.add(ticketPanel);

        // Adding components to the this panel
        add(buttonPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }

    public void addGBTicket(Component comp, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        ticketPanel.add(comp,gbc);
    }

    public void addGBPrevTicket(Component comp, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        prevTicketPanel.add(comp,gbc);
    }
}
