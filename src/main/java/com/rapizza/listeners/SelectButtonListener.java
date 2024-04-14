package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.rapizza.Client;
import com.rapizza.ClientPanel;

public class SelectButtonListener implements ActionListener {
    private ClientPanel parentPanel;
    private Client client;
    private JTextField quantityField;
    private JComboBox<String>  sizeComboBox; 
    private JLabel pizzaTitleLabel;

    public SelectButtonListener(ClientPanel parentPanel, Client client, JTextField quantityField, JComboBox<String> sizeComboBox, JLabel pizzaTitleLabel) {
        this.parentPanel = parentPanel;
        this.client = client;
        this.quantityField = quantityField;
        this.sizeComboBox = sizeComboBox;
        this.pizzaTitleLabel = pizzaTitleLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if the quantity is valid
        if (quantityField.getText().isEmpty() || !quantityField.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid quantity", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the selected pizza's name by parsing the title
        String pizzaTitle = pizzaTitleLabel.getText().substring(0, this.pizzaTitleLabel.getText().indexOf(" -"));

        // Get the quantity
        int quantity = Integer.parseInt(quantityField.getText());

        // Get the pizza's size
        String sizeText = (String) sizeComboBox.getSelectedItem();

        // Create a new line
        client.ajouterLigne(pizzaTitle, quantity, sizeText);

        // Refresh the panel
        parentPanel.refresh();
    }
    
}
