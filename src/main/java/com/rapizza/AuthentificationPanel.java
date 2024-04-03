package com.rapizza;

import javax.swing.*;
import java.awt.*;

public class AuthentificationPanel extends JPanel {

    public AuthentificationPanel() {
        // Set layout to GridBagLayout to center the components
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create label for "Phone Number"
        JLabel phoneNumberLabel = new JLabel("Phone Number");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START; // Aligner à gauche
        this.add(phoneNumberLabel, gbc);

        // Create the text field
        JTextField phoneNumberTextField = new JTextField();
        phoneNumberTextField.setPreferredSize(new Dimension(150, 24));

        // Center text horizontally within the text field
        phoneNumberTextField.setHorizontalAlignment(JTextField.CENTER);

        // Add the text field to the center of the panel
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(phoneNumberTextField, gbc);

        // Create a panel for radio buttons
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Create radio buttons
        JRadioButton userRadioButton = new JRadioButton("User");
        JRadioButton adminRadioButton = new JRadioButton("Admin");
        JRadioButton livreurRadioButton = new JRadioButton("Livreur");

        // Group the radio buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(userRadioButton);
        buttonGroup.add(adminRadioButton);
        buttonGroup.add(livreurRadioButton);

        // Add radio buttons to the panel
        radioPanel.add(userRadioButton);
        radioPanel.add(adminRadioButton);
        radioPanel.add(livreurRadioButton);

        // Add radio button panel to the bottom of the main panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(radioPanel, gbc);

        // Create a panel for the login button
        JPanel loginButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Create the login button
        JButton loginButton = new JButton("Login");

        // Add login button to the panel
        loginButtonPanel.add(loginButton);

        // Add login button panel to the bottom of the main panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(loginButtonPanel, gbc);
    }
}