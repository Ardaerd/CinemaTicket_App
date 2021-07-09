import Model.Branch;
import Model.Movie;
import Model.MovieTheaterGroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CalculationPanel extends JPanel {
    private JComboBox<Branch> branches;
    private JLabel info;
    private JLabel revenueLabel;
    private JLabel revenue;
    private GridBagConstraints gbc;
    private JLabel totalRevenueLabel;
    private JLabel totalRevenue;

    public CalculationPanel(MovieTheaterGroup movieTheaterGroup) {
        // Initializing the components
        branches = new JComboBox<Branch>();
        info = new JLabel("Select the branch for specific revenue");
        revenueLabel = new JLabel();
        revenue = new JLabel();
        gbc = new GridBagConstraints();
        totalRevenueLabel = new JLabel("Total Revenue for Cinemaximum:");
        totalRevenue = new JLabel();

        // Set Layout
        setLayout(new GridBagLayout());

        // Adding branches to the branches
        for (Branch branch : movieTheaterGroup.getListOfBranch()) {
            branches.addItem(branch);
        }

        branches.setSelectedIndex(-1);

        gbc.gridheight = 1;
        gbc.gridwidth = 2;

        gbc.insets = new Insets(20,50,10,50);

        gbc.anchor = GridBagConstraints.CENTER;
        addGB(info,0,0);

        gbc.ipadx = 50;
        gbc.anchor = GridBagConstraints.CENTER;
        addGB(branches,0,1);

        branches.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Branch branch = (Branch) e.getItem();

                    revenueLabel.setText("Revenue for " + branch + ": ");

                    String revenueStr = String.format("+%s",movieTheaterGroup.calculateBranchRevenue(branch));
                    revenue.setText(revenueStr + " TL");
                    revenue.setForeground(new Color(28, 180, 11));

                    String totalRevenueStr = String.format("%s TL",movieTheaterGroup.calculateTotalRevenue());
                    totalRevenue.setText(totalRevenueStr);

                    gbc.gridheight = 1;
                    gbc.gridwidth = 1;

                    gbc.insets = new Insets(60,50,10,50);

                    gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                    addGB(revenueLabel,0,2);

                    gbc.anchor = GridBagConstraints.FIRST_LINE_END;
                    addGB(revenue,1,2);

                    gbc.insets = new Insets(30,50,10,50);

                    gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                    addGB(totalRevenueLabel,0,3);

                    gbc.anchor = GridBagConstraints.FIRST_LINE_END;
                    addGB(totalRevenue,1,3);

                    revalidate();
                    repaint();
                }
            }
        });
    }

    public void addGB(Component comp, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        add(comp,gbc);
    }

}
