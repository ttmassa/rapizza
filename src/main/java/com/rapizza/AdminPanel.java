package com.rapizza;

import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel {
    
    public AdminPanel() {
        // Set layout to BorderLayout
        this.setLayout(new BorderLayout());
        
        // Create title 
        JLabel titleLabel = new JLabel("Admin Panel");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        this.add(titleLabel, BorderLayout.NORTH);

        // Create a JPanel for the logout button
        JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton logoutButton = new JButton("Logout");
        logoutButton.setPreferredSize(new Dimension(100, 30));
        logoutPanel.add(logoutButton);
        
        // Add the logout panel to the south border
        this.add(logoutPanel, BorderLayout.SOUTH);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new GridBagLayout());

        // Create the buttons
        JButton addPizzaButton = new JButton("Add Pizza");
        JButton addPizzeriaButton = new JButton("Add Pizzeria");
        JButton addLivreurButton = new JButton("Add Livreur");

        // Set preferred size for the buttons
        Dimension buttonSize = new Dimension(150, 30);
        addPizzaButton.setPreferredSize(buttonSize);
        addPizzeriaButton.setPreferredSize(buttonSize);
        addLivreurButton.setPreferredSize(buttonSize);

        // Add the buttons to the panel using GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // Add some padding
        gbc.anchor = GridBagConstraints.CENTER;
        buttonPanel.add(addPizzaButton, gbc);

        gbc.gridx = 1;
        buttonPanel.add(addPizzeriaButton, gbc);

        gbc.gridx = 2;
        buttonPanel.add(addLivreurButton, gbc);

        // Add the button panel to the center of the main panel
        this.add(buttonPanel, BorderLayout.CENTER);
    }
}
