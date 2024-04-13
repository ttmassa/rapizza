package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import com.rapizza.AdminPanel;
import com.rapizza.Ingredient;
import com.rapizza.Pizza;
import com.rapizza.Pizzeria;

/*
 * HelpButtonListener is used to avoid the admin to create everything from scratch everytime he opens the app.
 * It automatically adds 3 pizzerias, 3 pizzas and 6 ingredients to the app.
 */
public class HelpButtonListener implements ActionListener {
    private static boolean isUsed = false;
    private AdminPanel parentPanel;

    public HelpButtonListener(AdminPanel parentPanel) {
        this.parentPanel = parentPanel;
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (isUsed) {
            return;
        }

        // Add 3 pizzerias
        Pizzeria pizzeria1 = new Pizzeria("1 rue de la paix");
        Pizzeria pizzeria2 = new Pizzeria("2 rue de la paix");
        Pizzeria pizzeria3 = new Pizzeria("3 rue de la paix");

        // Add 6 ingredients
        Ingredient ingredient1 = new Ingredient("Tomato", 1.0);
        Ingredient ingredient2 = new Ingredient("Mozzarella", 1.0);
        Ingredient ingredient3 = new Ingredient("Ham", 1.0);
        Ingredient ingredient4 = new Ingredient("Mushrooms", 1.0);
        Ingredient ingredient5 = new Ingredient("Pepperoni", 1.0);
        Ingredient ingredient6 = new Ingredient("Onions", 1.0);

        // Add 5 pizzas
        Pizza pizza1 = new Pizza("Margherita", 5.0, new Vector<>(Arrays.asList(ingredient1, ingredient2)));
        Pizza pizza2 = new Pizza("Pepperoni", 6.0, new Vector<>(Arrays.asList(ingredient1, ingredient2, ingredient5)));
        Pizza pizza3 = new Pizza("Hawaiian", 7.0, new Vector<>(Arrays.asList(ingredient1, ingredient2, ingredient3)));
        Pizza pizza4 = new Pizza("Vegetarian", 6.0, new Vector<>(Arrays.asList(ingredient1, ingredient2, ingredient4, ingredient6)));
        Pizza pizza5 = new Pizza("Meat Lovers", 8.0, new Vector<>(Arrays.asList(ingredient1, ingredient2, ingredient3, ingredient5)));

        // Add the pizzas to the pizzerias
        pizzeria1.ajouterPizza(pizza1);
        pizzeria1.ajouterPizza(pizza2);
        pizzeria1.ajouterPizza(pizza3);
        pizzeria2.ajouterPizza(pizza4);
        pizzeria2.ajouterPizza(pizza5);
        pizzeria3.ajouterPizza(pizza1);
        pizzeria3.ajouterPizza(pizza2);
        pizzeria3.ajouterPizza(pizza3);
        pizzeria3.ajouterPizza(pizza4);
        pizzeria3.ajouterPizza(pizza5);

        // Refresh the panel
        parentPanel.refreshPanel();
    }

    public static boolean isUsed() {
        return isUsed;
    }
}
