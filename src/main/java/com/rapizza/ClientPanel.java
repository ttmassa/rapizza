package com.rapizza;

import javax.swing.*;

import com.rapizza.listeners.LogoutButtonListener;

import java.awt.*;
import java.util.Vector;

public class ClientPanel extends JPanel {
    private Pizzeria pizzeria;
    private final int CARD_HEIGHT = 140; 

    public ClientPanel(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;

        // Set layout to BorderLayout
        this.setLayout(new BorderLayout());

        // Toolbar (Commands and Settings)
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        // Create the buttons
        JButton commandButton = new JButton("Commands");
        commandButton.setToolTipText("Make a new order");
        configureLinkButton(commandButton);

        JButton settingsButton = new JButton("Settings");
        settingsButton.setToolTipText("Change your settings");
        configureLinkButton(settingsButton);

        // Create logout button
        JButton logoutButton = new JButton("Logout");
        configureLinkButton(logoutButton);

        LogoutButtonListener logoutButtonListener = new LogoutButtonListener(this);
        logoutButton.addActionListener(logoutButtonListener);

        // Add the buttons to the toolbar
        toolbar.add(commandButton);
        toolbar.addSeparator();
        toolbar.add(settingsButton);
        toolbar.addSeparator();
        toolbar.add(logoutButton);

        this.add(toolbar, BorderLayout.NORTH);

        // Main panel
        JPanel mainPanel = new JPanel();
        int nbrColumns = pizzeria.menu.size();

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        // Create gaps between the cards
        gbc.insets = new Insets(10, 10, 10, 10);

        // Create the menu
        for (Pizza pizza : pizzeria.menu) {
            JPanel card = createPizzaCard(pizza.nom, pizza.prixMarge, pizza.ingredients);
            gbc.gridx = pizzeria.menu.indexOf(pizza) % nbrColumns;
            gbc.gridy = pizzeria.menu.indexOf(pizza) / nbrColumns;
            gbc.fill = GridBagConstraints.BOTH; 
            card.setPreferredSize(new Dimension(card.getPreferredSize().width, CARD_HEIGHT)); 

            mainPanel.add(card, gbc);
        }

        this.add(mainPanel, BorderLayout.CENTER);

        // Create the command button
        JButton orderButton = new JButton("Order");
        // Increase the font size
        orderButton.setFont(orderButton.getFont().deriveFont(16.0f));
        configureOrderButton(orderButton);
        this.add(orderButton, BorderLayout.SOUTH);
    }

    public Pizzeria getPizzeria() {
        return pizzeria;
    }

    private JPanel createPizzaCard(String title, double price, Vector<Ingredient> ingredients) {
        // Create a new card
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        card.setBackground(Color.WHITE);
        // Add padding to the card
        card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        // Create the title
        JLabel titleLabel = new JLabel(title + " - " + price + "€");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 16)); // Increase font size
        card.add(titleLabel, BorderLayout.NORTH);
    
        // Create the ingredients panel
        JPanel ingredientsPanel = new JPanel();
        ingredientsPanel.setBackground(Color.WHITE);
        ingredientsPanel.setLayout(new GridLayout(0, 1)); // Vertical layout for ingredients
        for (Ingredient ingredient : ingredients) {
            JLabel ingredientLabel = new JLabel(ingredient.nom);
            ingredientsPanel.add(ingredientLabel);
        }
        // Add border below ingredients section
        ingredientsPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY));
        card.add(ingredientsPanel, BorderLayout.CENTER);
    
        // Create a select button
        JButton selectButton = new JButton("Select");
        selectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        selectButton.setFocusable(false);
        selectButton.setBorderPainted(false);
        selectButton.setContentAreaFilled(false);
        selectButton.setBackground(Color.BLUE); // Set background color to blue
        selectButton.setForeground(Color.WHITE); // Set text color to white
        selectButton.setFont(selectButton.getFont().deriveFont(Font.BOLD)); // Make text bold
        selectButton.setOpaque(true); // Make the button opaque to show background color
        // Add border above select button
        selectButton.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY));
        card.add(selectButton, BorderLayout.SOUTH);
    
        return card; // Return the created card
    }
    
    private void configureLinkButton(JButton button) {
        button.setForeground(Color.BLUE);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
    }

    private void configureOrderButton(JButton button) {
        button.setToolTipText("Order the selected pizzas");
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusable(false);
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }
}
