package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.rapizza.AdminPanel;
import com.rapizza.Pizzeria;

public class AddPizzeriaButtonListener implements ActionListener {
    private AdminPanel adminPanel;
    private JTextField adresse;

    public AddPizzeriaButtonListener(JTextField adresse, AdminPanel adminPanel) {
        this.adresse = adresse;
        this.adminPanel = adminPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if the text field is filled
        if (adresse.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in an address");
        }

        // Get the text from the text field
        String address = adresse.getText();

        // Create the pizzeria
        new Pizzeria(address);

        // Clear the text field
        adresse.setText("");

        // Refresh the entire panel
        adminPanel.refreshPanel();

        // Display a success message
        JOptionPane.showMessageDialog(null, "Pizzeria added successfully");
    }
}
