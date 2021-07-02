import javax.swing.*;
import java.awt.*;

public class CinemaximumAtaşehir_Panel extends JPanel {
    private JButton newCustomer;
    private JButton existingCustomer;

    public CinemaximumAtaşehir_Panel() {
        // Initializing components for the Ataşehir branch
        newCustomer = new JButton("New Customer");
        existingCustomer = new JButton("Existing Customer");

        // Setting Layout
        setLayout(new FlowLayout());

        // 

        // Adding components to the Ataşehir panel
        add(newCustomer);
        add(existingCustomer);
    }
}
