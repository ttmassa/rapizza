package com.rapizza;

import javax.swing.*;

import com.rapizza.listeners.LogoutButtonListener;

import java.awt.*;
import java.util.Vector;

public class ClientPanel extends JPanel {
    private Pizzeria pizzeria;
    private final int CARD_HEIGHT = 150;
    private final int CARD_WIDTH = 200;

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

        // Add action listener to the logout button
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
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 

        // Create the menu
        for (Pizza pizza : pizzeria.menu) {
            JPanel card = createPizzaCard(pizza.nom, pizza.prixMarge, pizza.ingredients);
            card.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));
            mainPanel.add(card);
        }

        this.add(mainPanel, BorderLayout.CENTER);

        // Create the command button
        JButton orderButton = new JButton("Order");
        // Increase the font size
        orderButton.setFont(orderButton.getFont().deriveFont(16.0f));
        configureOrderButton(orderButton);
        this.add(orderButton, BorderLayout.SOUTH);
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
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 16)); 
        card.add(titleLabel, BorderLayout.NORTH);

        // Add a border below the title
        titleLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        // Create the main panel
        JPanel maiPanel = new JPanel();
        maiPanel.setLayout(new BorderLayout());
        maiPanel.setBackground(Color.WHITE);

        // Create the ingredients panel
        JPanel ingredientsPanel = new JPanel();
        ingredientsPanel.setBackground(Color.WHITE);
        ingredientsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        for (Ingredient ingredient : ingredients) {
            JLabel ingredientLabel = new JLabel(ingredient.nom);
            ingredientLabel.setFont(ingredientLabel.getFont().deriveFont(Font.ITALIC));
            ingredientsPanel.add(ingredientLabel);
        }
        // No border added to the ingredients panel
        maiPanel.add(ingredientsPanel, BorderLayout.NORTH);

        // Create a combobox for the pizza size
        JComboBox<String> sizeComboBox = new JComboBox<>(new String[] { "Naine", "Humaine", "Ogresse" });
        sizeComboBox.setSelectedIndex(1); 
        sizeComboBox.setFocusable(false);
        sizeComboBox.setBackground(Color.WHITE);
        maiPanel.add(sizeComboBox, BorderLayout.SOUTH);

        card.add(maiPanel, BorderLayout.CENTER);

        // Add space between ingredients and select button
        maiPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Create a select button
        JButton selectButton = new JButton("Select");
        configureSelectButton(selectButton);

        // Add border above select button
        card.add(selectButton, BorderLayout.SOUTH);

        return card;
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

    private void configureSelectButton(JButton button) {
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
        button.setFont(button.getFont().deriveFont(Font.BOLD));
        button.setOpaque(true);
        button.setBorder(BorderFactory.createEmptyBorder(7, 0, 7, 0));
    }

    public Pizzeria getPizzeria() {
        return pizzeria;
    }
}
