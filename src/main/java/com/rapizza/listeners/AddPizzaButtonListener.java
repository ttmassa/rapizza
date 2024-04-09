package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.rapizza.Ingredient;
import com.rapizza.Pizza;

public class AddPizzaButtonListener implements ActionListener {
    private JTextField pizzaName;
    private JTextField pizzaPrice;
    private JComboBox<JCheckBox> listIngredients;


    public AddPizzaButtonListener(JTextField pizzaName, JTextField pizzaPrice, JComboBox<JCheckBox> listIngredients) {
        this.pizzaName = pizzaName;
        this.pizzaPrice = pizzaPrice;
        this.listIngredients = listIngredients;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if the pizza name and price are filled
        if (pizzaName.getText().isEmpty() || pizzaPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in a name and price");
        }

        // Get the text from the text fields
        String name = pizzaName.getText();
        String price = pizzaPrice.getText();

        // Convert the price to a double
        double priceDouble = Double.parseDouble(price);    
        
        // Get the selected ingredients
        Vector<Ingredient> ingredients = new Vector<Ingredient>();
        for (int i = 0; i < listIngredients.getItemCount(); i++) {
            JCheckBox checkBox = (JCheckBox) listIngredients.getItemAt(i);
            if (checkBox.isSelected()) {
                ingredients.add(Ingredient.listIngredients.get(i));
            }
        }

        // Create the pizza
        Pizza pizza = new Pizza(name, priceDouble, ingredients);
        Pizza.listPizzas.add(pizza);

        // Clear the text fields
        pizzaName.setText("");
        pizzaPrice.setText("");

        // Refresh the checkbox list
        for (int i = 0; i < listIngredients.getItemCount(); i++) {
            JCheckBox checkBox = (JCheckBox) listIngredients.getItemAt(i);
            checkBox.setSelected(false);
        }

        // Display a success message
        JOptionPane.showMessageDialog(null, "Pizza added successfully");
    }

}