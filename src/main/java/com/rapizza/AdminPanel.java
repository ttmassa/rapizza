package com.rapizza;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;

import com.rapizza.listeners.AddIngredientButtonListener;
import com.rapizza.listeners.AddPizzeriaButtonListener;
import com.rapizza.listeners.LogoutButtonListener;

public class AdminPanel extends JPanel {
    public AdminPanel() {
        // Set layout for the AdminPanel
        setLayout(new BorderLayout());

        // Create and add the toolbar to the top of the frame
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false); 
        toolBar.setBackground(Color.WHITE); 

        JButton profileButton = new JButton("Profile");
        configureLinkButton(profileButton);
        toolBar.add(profileButton);

        // Logout button
        JButton logoutButton = new JButton("Logout");
        configureLinkButton(logoutButton);
        toolBar.add(logoutButton);

        LogoutButtonListener logoutButtonListener = new LogoutButtonListener(this);
        logoutButton.addActionListener(logoutButtonListener);

        add(toolBar, BorderLayout.NORTH);

        // Create main content panel with BoxLayout
        JPanel mainContentPanel = new JPanel();
        mainContentPanel.setLayout(new BoxLayout(mainContentPanel, BoxLayout.Y_AXIS));

        // Row 1: Add a Pizza
        JPanel addPizzaPanel = new JPanel(new GridBagLayout());
        addPizzaPanel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel addPizzaLabel = new JLabel("Add a Pizza");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 5); 
        gbc.anchor = GridBagConstraints.WEST;
        addPizzaPanel.add(addPizzaLabel, gbc);

        JTextField pizzaNameField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 5); 
        addPizzaPanel.add(pizzaNameField, gbc);

        // Create a text field for the price
        JLabel pizzaPriceLabel = new JLabel("Price");
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 5);
        addPizzaPanel.add(pizzaPriceLabel, gbc);

        JTextField pizzaPriceField = new JTextField(10);
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 5);
        addPizzaPanel.add(pizzaPriceField, gbc);

        // Add checkboxes for ingredients inside JScrollPane for sliding effect
        
        // Get the list of ingredients names from the Ingredient class
        Vector<String> ingredients = new Vector<>();
        for (Ingredient ingredient : Ingredient.listIngredients) {
            ingredients.add(ingredient.nom);
        }

        Vector<JCheckBox> ingredientCheckboxes = new Vector<>();
        JPanel ingredientPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        for (String ingredient : ingredients) {
            JCheckBox checkBox = new JCheckBox(ingredient);
            ingredientCheckboxes.add(checkBox);
            ingredientPanel.add(checkBox);
        }
        JScrollPane scrollPane = new JScrollPane(ingredientPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 50)); 
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 5); 
        addPizzaPanel.add(scrollPane, gbc);

        // Add a button to create the pizza
        JButton addPizzaButton = new JButton("Create Pizza");
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST; 
        addPizzaPanel.add(addPizzaButton, gbc);

        // Create top margin for the panel
        addPizzaPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        mainContentPanel.add(addPizzaPanel);

        // Add vertical strut to create space between rows
        mainContentPanel.add(Box.createVerticalStrut(10));

        // Row 2: Add a Pizzeria
        JPanel addPizzeriaPanel = new JPanel(new GridBagLayout());
        addPizzeriaPanel.setAlignmentX(Component.CENTER_ALIGNMENT); 

        JLabel addPizzeriaLabel = new JLabel("Add a Pizzeria");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 10);
        addPizzeriaPanel.add(addPizzeriaLabel, gbc);

        JTextField pizzeriaAddressField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 10);
        addPizzeriaPanel.add(pizzeriaAddressField, gbc);

        JButton addPizzeriaButton = new JButton("Add a Pizzeria");
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        addPizzeriaPanel.add(addPizzeriaButton, gbc);

        // Add the listener to the button
        AddPizzeriaButtonListener addPizzeriaButtonListener = new AddPizzeriaButtonListener(pizzeriaAddressField);
        addPizzeriaButton.addActionListener(addPizzeriaButtonListener);

        mainContentPanel.add(addPizzeriaPanel);

        // Add vertical strut to create space between rows
        mainContentPanel.add(Box.createVerticalStrut(10));

        // Row 3: Recruit
        JPanel recruitPanel = new JPanel(new GridBagLayout());
        recruitPanel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel recruitLabel = new JLabel("Recruit a Delivery Guy");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 10);
        recruitPanel.add(recruitLabel, gbc);

        JComboBox<String> deliveryGuyComboBox = new JComboBox<>(new Vector<>()); 
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 10);
        recruitPanel.add(deliveryGuyComboBox, gbc);

        JButton recruitButton = new JButton("Recruit");
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        recruitPanel.add(recruitButton, gbc);

        mainContentPanel.add(recruitPanel);

        // Add vertical strut to create space between rows
        mainContentPanel.add(Box.createVerticalStrut(10));

        //Row 4: Add an Ingredient
        JPanel addIngredientPanel = new JPanel(new GridBagLayout());
        addIngredientPanel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel addIngredientLabel = new JLabel("Add an Ingredient");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 10);
        addIngredientPanel.add(addIngredientLabel, gbc);

        JTextField ingredientNameField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 10);
        addIngredientPanel.add(ingredientNameField, gbc);

        JLabel ingredientPriceLabel = new JLabel("Price");
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 10);
        addIngredientPanel.add(ingredientPriceLabel, gbc);

        JTextField ingredientPriceField = new JTextField(10);
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 10);
        addIngredientPanel.add(ingredientPriceField, gbc);

        JButton addIngredientButton = new JButton("Add Ingredient");
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        addIngredientPanel.add(addIngredientButton, gbc);

        // Add the listener to the button
        AddIngredientButtonListener addIngredientButtonListener = new AddIngredientButtonListener(ingredientNameField, ingredientPriceField, this);
        addIngredientButton.addActionListener(addIngredientButtonListener);

        mainContentPanel.add(addIngredientPanel);

        add(mainContentPanel, BorderLayout.CENTER);
    }

    private void configureLinkButton(JButton button) {
        button.setForeground(Color.BLUE);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
    }

    // Not good because it's used in multiple classes
    public void showAuthentificationPanel() {
        removeAll();
        AuthentificationPanel authentificationPanel = new AuthentificationPanel();
        setLayout(new BorderLayout());
        add(authentificationPanel);
        revalidate();
        repaint();
    }

    public void refreshPanel() {
        removeAll();
        AdminPanel adminPanel = new AdminPanel();
        setLayout(new BorderLayout());
        add(adminPanel);
        revalidate();
        repaint();
    }
}
