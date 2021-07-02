import Model.Branch;
import Model.MovieTheaterGroup;

import javax.swing.*;
import java.awt.*;

public class CinemaTicket_GUI extends JPanel {
    private JPanel CinemaximumTaksim_Panel;
    private JPanel CinemaximumLevent_Panel;
    private JPanel CinemaximumAtaşehir_Panel;
    private JButton newCustomer;
    private JButton existingCustomer;
    private JTabbedPane tabPanel;
    private MovieTheaterGroup movieTheaterGroup;

    public CinemaTicket_GUI() {
        // Initializing components
        CinemaximumAtaşehir_Panel = new CinemaximumAtaşehir_Panel();
        CinemaximumTaksim_Panel = new CinemaximumTaksim_Panel();
        CinemaximumLevent_Panel = new CinemaximumLevent_Panel();
        tabPanel = new JTabbedPane();
        movieTheaterGroup = new MovieTheaterGroup("Cinemaximum");

        // Setting size
        tabPanel.setPreferredSize(new Dimension(main.WIDTH-20,main.HEIGHT-50));

        // Adding branch to the tab from the branch class
        tabPanel.addTab(movieTheaterGroup.getListOfBranch().get(0).getNameOfBranch(), CinemaximumAtaşehir_Panel);
        tabPanel.addTab(movieTheaterGroup.getListOfBranch().get(1).getNameOfBranch(),CinemaximumTaksim_Panel);
        tabPanel.addTab(movieTheaterGroup.getListOfBranch().get(2).getNameOfBranch(),CinemaximumLevent_Panel);


        add(tabPanel);
    }
}
