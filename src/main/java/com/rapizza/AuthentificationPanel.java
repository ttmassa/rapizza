package com.rapizza;

import javax.swing.*;
import com.rapizza.listeners.LoginButtonListener;
import com.rapizza.listeners.PhoneNumberListener;
import java.awt.*;

/*
 *  Get all the pizzerias from a newly created Vector<Pizzeria> and add the adress of each pizzeria to the JComboBox 
 */

public class AuthentificationPanel extends JPanel {
    private JRadioButton clientRadioButton;
    private JRadioButton adminRadioButton;
    private JRadioButton livreurRadioButton;
    private PhoneNumberListener phoneNumberListener; 
    private JComboBox<String> pizzeriaComboBox = new JComboBox<>();

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

        // Create the phone number text field
        JTextField phoneNumberTextField = new JTextField();
        phoneNumberTextField.setPreferredSize(new Dimension(150, 24));
        phoneNumberTextField.setHorizontalAlignment(JTextField.CENTER);

        // Add the text field to the center of the panel
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(phoneNumberTextField, gbc);

        // Create a listener for the phone number text field
        phoneNumberListener = new PhoneNumberListener(phoneNumberTextField); // Store the listener
        phoneNumberTextField.getDocument().addDocumentListener(phoneNumberListener); // Register the listener

        // Create label for "Pizzeria"
        JLabel pizzeriaLabel = new JLabel("Pizzeria");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(pizzeriaLabel, gbc);

        // Create a combo box for pizzerias
        if (Pizzeria.listPizzerias.size() == 0) {
            pizzeriaComboBox.addItem("No pizzerias available");
        } else {
            for (int i = 0; i < Pizzeria.listPizzerias.size(); i++) {
                String adresse = Pizzeria.listPizzerias.get(i).adresse;
                pizzeriaComboBox.addItem(adresse);
            }    
        }


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

        // Group the radio buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(clientRadioButton);
        buttonGroup.add(adminRadioButton);
        buttonGroup.add(livreurRadioButton);

        // Add radio buttons to the panel
        radioPanel.add(clientRadioButton);
        radioPanel.add(adminRadioButton);

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

    public PhoneNumberListener getPhoneNumberListener() {
        return phoneNumberListener; 
    }

    public boolean isRadioSelected() {
        return clientRadioButton.isSelected() || adminRadioButton.isSelected() || livreurRadioButton.isSelected();
    }

    public Pizzeria getPizzeriaSelected() {
        String adresse = (String) pizzeriaComboBox.getSelectedItem();

        for (Pizzeria pizzeria : Pizzeria.listPizzerias) {
            if (pizzeria.adresse.equals(adresse)) {
                return pizzeria;
            }
        }

        return null;
    }
}
