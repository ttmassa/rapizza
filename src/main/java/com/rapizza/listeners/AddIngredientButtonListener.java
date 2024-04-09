package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import com.rapizza.AdminPanel;
import com.rapizza.Ingredient;

public class AddIngredientButtonListener implements ActionListener {
    private JTextField  ingredientName;
    private JTextField  ingredientPrice;
    private AdminPanel adminPanel;

    public AddIngredientButtonListener(JTextField ingredientName, JTextField ingredientPrice, AdminPanel adminPanel) {
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.adminPanel = adminPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if the text fields are filled
        if (ingredientName.getText().isEmpty() || ingredientPrice.getText().isEmpty()) {
            System.out.println("Please fill in a name and price");
        }

        // Get the text from the text fields
        String name = ingredientName.getText();
        String price = ingredientPrice.getText();

        // Convert the price to a double
        double priceDouble = Double.parseDouble(price);

        // Create the ingredient
        Ingredient ingredient = new Ingredient(name, priceDouble);
        Ingredient.listIngredients.add(ingredient);

        // Clear the text fields
        ingredientName.setText("");
        ingredientPrice.setText("");

        // Refresh the ingredient list
        adminPanel.refreshPanel();

        // Display a success message
        System.out.println("Ingredient added successfully");
    }
}
