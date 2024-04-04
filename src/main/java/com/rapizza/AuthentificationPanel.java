package com.rapizza;

import javax.swing.*;

import com.rapizza.listeners.LoginButtonListener;

import java.awt.*;

public class AuthentificationPanel extends JPanel {
    private JRadioButton clientRadioButton;
    private JRadioButton adminRadioButton;
    private JRadioButton livreurRadioButton;

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
        phoneNumberLabel.isCursorSet();
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

        // Create label for "Pizzeria"
        JLabel pizzeriaLabel = new JLabel("Pizzeria");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(pizzeriaLabel, gbc);

        // Create a combo box for pizzerias
        JComboBox<String> pizzeriaComboBox = new JComboBox<>();
        pizzeriaComboBox.addItem("1 rue de la pizza");
        pizzeriaComboBox.addItem("2 rue de la pizza");
        pizzeriaComboBox.addItem("3 rue de la pizza");

        pizzeriaComboBox.setPreferredSize(new Dimension(150, 24));

        // Add the combo box to the center of the panel, exactly below the phoneNumber components
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(pizzeriaComboBox, gbc);

        // Create a panel for radio buttons
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Create radio buttons
        clientRadioButton = new JRadioButton("Client");
        adminRadioButton = new JRadioButton("Admin");
        livreurRadioButton = new JRadioButton("Livreur");

        // Group the radio buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(clientRadioButton);
        buttonGroup.add(adminRadioButton);
        buttonGroup.add(livreurRadioButton);

        // Add radio buttons to the panel
        radioPanel.add(clientRadioButton);
        radioPanel.add(adminRadioButton);
        radioPanel.add(livreurRadioButton);

        // Add radio button panel to the bottom of the main panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(radioPanel, gbc);

        // Create a panel for the login button
        JPanel loginButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Create the login button
        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(125, 30));

        LoginButtonListener loginButtonListener = new LoginButtonListener(this);
        loginButton.addActionListener(loginButtonListener);

        // Add login button to the panel
        loginButtonPanel.add(loginButton);

        // Add login button panel to the bottom of the main panel
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(loginButtonPanel, gbc);
    }

    public void showClientPanel() {
        removeAll();
        ClientPanel clientPanel = new ClientPanel();
        this.setLayout(new BorderLayout());
        add(clientPanel);
        revalidate();
        repaint();
    }

    public void showAdminPanel() {
        removeAll();
        AdminPanel adminPanel = new AdminPanel();
        this.setLayout(new BorderLayout());
        add(adminPanel);
        revalidate();
        repaint();
    }

    public boolean isClientSelected() {
        return clientRadioButton.isSelected();
    }

    public boolean isLivreurSelected() {
        return livreurRadioButton.isSelected();
    }

    public boolean isAdminSelected() {
        return adminRadioButton.isSelected();
    }
}
