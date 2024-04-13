package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.rapizza.AdminPanel;
import com.rapizza.Ingredient;
import com.rapizza.Pizza;
import com.rapizza.Pizzeria;

public class AddPizzaButtonListener implements ActionListener {
    private JTextField pizzaName;
    private JTextField pizzaPrice;
    private Vector<JCheckBox> listIngredients;
    private AdminPanel adminPanel;


    public AddPizzaButtonListener(JTextField pizzaName, JTextField pizzaPrice, Vector<JCheckBox> listIngredients, AdminPanel adminPanel) {
        this.pizzaName = pizzaName;
        this.pizzaPrice = pizzaPrice;
        this.listIngredients = listIngredients;
        this.adminPanel = adminPanel;
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
        Vector<Ingredient> ingredients = new Vector<>();
        for (JCheckBox checkBox : listIngredients) {
            if (checkBox.isSelected()) {
                Ingredient ingredient = Ingredient.listIngr.get(listIngredients.indexOf(checkBox));
                ingredients.add(ingredient);
            }
        }

        // Create the pizza
        Pizza pizza = new Pizza(name, priceDouble, ingredients);
        for (Pizzeria pizzeria : Pizzeria.listPizzerias) {
            pizzeria.ajouterPizza(pizza);
        }

        // Clear the text fields
        pizzaName.setText("");
        pizzaPrice.setText("");

        // Refresh the pizza list
        adminPanel.refreshPanel();

        // Display a success message
        JOptionPane.showMessageDialog(null, "Pizza added successfully");
    }

}