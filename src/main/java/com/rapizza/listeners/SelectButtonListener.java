package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.rapizza.LigneC;
import com.rapizza.Pizza;
import com.rapizza.TaillePizza;

public class SelectButtonListener implements ActionListener {
    private JTextField quantityField;
    private JComboBox<String>  sizeComboBox; 
    private JLabel pizzaTitleLabel;

    public SelectButtonListener(JTextField quantityField, JComboBox<String> sizeComboBox, JLabel pizzaTitleLabel) {
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

        // Get the selected pizza
        String pizzaTitle = pizzaTitleLabel.getText();
    
        Pizza selectedPizza = null;
        for (Pizza pizza : Pizza.listPizzas) {
            if (pizza.nom.equals(pizzaTitle)) {
                selectedPizza = pizza;
            }
        
        }

        if (selectedPizza == null) {
            JOptionPane.showMessageDialog(null, "Pizza does not exist in database", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the quantity
        int quantity = Integer.parseInt(quantityField.getText());

        // Get the pizza's size
        String sizeText = (String) sizeComboBox.getSelectedItem();
        TaillePizza size = TaillePizza.valueOf(sizeText);

        // Create a new line
        new LigneC(selectedPizza, quantity, size);
    }
    
}
