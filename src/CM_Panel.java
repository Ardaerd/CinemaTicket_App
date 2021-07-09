import Model.MovieTheaterGroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CM_Panel extends JPanel {
    private JButton displayTickets;
    private JButton displayCalculation;
    private DisplayTickets_Panel displayTickets_panel;
    private CalculationPanel calculationPanel;
    private JPanel buttonPanel;
    private JPanel mainPanel;
    private boolean displayAllTicketsClicked;
    private boolean displayCalculationClicked;

    public CM_Panel(MovieTheaterGroup movieTheaterGroup) {
        // Initializing the components
        displayTickets = new JButton("Display All Tickets");
        displayCalculation = new JButton("Make Calculation");
        buttonPanel = new JPanel();
        mainPanel = new JPanel();

        // Setting layout
        setLayout(new BorderLayout());
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,15,10));

        // Adding buttons to the buttonPanel
        buttonPanel.add(displayTickets);
        buttonPanel.add(displayCalculation);

        // AddingActionListener to the buttonPanel
        displayTickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    if (displayAllTicketsClicked)
                        mainPanel.remove(displayTickets_panel);
                    else if (displayCalculationClicked) {
                        mainPanel.remove(calculationPanel);
                        displayCalculationClicked = false;
                    }
                    displayAllTicketsClicked = true;
                    displayTickets_panel = new DisplayTickets_Panel(movieTheaterGroup);
                    mainPanel.add(displayTickets_panel);
                    mainPanel.repaint();
                    mainPanel.revalidate();
                }
            }
        });

        displayCalculation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (displayAllTicketsClicked) {
                    mainPanel.remove(displayTickets_panel);
                    displayAllTicketsClicked = false;
                } else if (displayCalculationClicked) {
                    mainPanel.remove(calculationPanel);
                }
                displayCalculationClicked = true;
                calculationPanel = new CalculationPanel(movieTheaterGroup);
                mainPanel.add(calculationPanel);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });

        add(buttonPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }
}
