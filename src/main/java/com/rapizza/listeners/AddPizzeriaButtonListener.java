package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.rapizza.Pizzeria;

public class AddPizzeriaButtonListener implements ActionListener {
    private JTextField adresse;

    public AddPizzeriaButtonListener(JTextField adresse) {
        this.adresse = adresse;
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
        Pizzeria pizzeria = new Pizzeria(address);
        Pizzeria.listPizzerias.add(pizzeria);

        // Clear the text field
        adresse.setText("");

        // Display a success message
        JOptionPane.showMessageDialog(null, "Pizzeria added successfully");
    }
}
