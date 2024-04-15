package com.rapizza;

import javax.swing.*;

import com.rapizza.listeners.DeleteButtonListener;
import com.rapizza.listeners.LogoutButtonListener;
import com.rapizza.listeners.OrderButtonListener;
import com.rapizza.listeners.ProfileButtonListener;
import com.rapizza.listeners.SelectButtonListener;

import java.awt.*;
import java.util.Vector;

public class ClientPanel extends JPanel {
    private Client client;
    private Pizzeria pizzeria;
    private final int CARD_HEIGHT = 150;
    private final int CARD_WIDTH = 200;

    public ClientPanel(Client client, Pizzeria pizzeria) {
        this.client = client;
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

        // Create profile button
        JButton profileButton = new JButton("Profile");
        profileButton.setToolTipText("View your profile");
        configureLinkButton(profileButton);

        // Add a listener to the profile button
        ProfileButtonListener profileButtonListener = new ProfileButtonListener(this, client);
        profileButton.addActionListener(profileButtonListener);

        // Create logout button
        JButton logoutButton = new JButton("Logout");
        configureLinkButton(logoutButton);

        // Add action listener to the logout button
        LogoutButtonListener logoutButtonListener = new LogoutButtonListener(this);
        logoutButton.addActionListener(logoutButtonListener);

        // Add the buttons to the toolbar
        toolbar.add(commandButton);
        toolbar.addSeparator();
        toolbar.add(profileButton);
        toolbar.addSeparator();
        toolbar.add(logoutButton);

        this.add(toolbar, BorderLayout.NORTH);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 

        // Create the menu
        for (Pizza pizza : pizzeria.menu) {
            JPanel card = createPizzaCard(pizza.nom, pizza.getPrix(), pizza.ingredients);
            card.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));
            mainPanel.add(card);
        }

        this.add(mainPanel, BorderLayout.CENTER);

        // Create the order recap on the side
        JPanel orderRecapPanel = new JPanel();
        orderRecapPanel.setLayout(new BorderLayout());
        orderRecapPanel.setPreferredSize(new Dimension(150, 0));
        orderRecapPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Add padding to the order recap panel
        orderRecapPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create the order recap title
        JLabel orderRecapTitle = new JLabel("Order Recap");
        orderRecapTitle.setHorizontalAlignment(JLabel.CENTER);
        orderRecapTitle.setForeground(Color.BLACK);
        orderRecapPanel.setBackground(Color.WHITE);
        orderRecapTitle.setFont(orderRecapTitle.getFont().deriveFont(Font.BOLD, 16));
        orderRecapPanel.add(orderRecapTitle, BorderLayout.NORTH);

        // Add a border below the title
        orderRecapTitle.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        
        // Create the order recap list
        JPanel orderRecapList = new JPanel();
        orderRecapList.setLayout(new BoxLayout(orderRecapList, BoxLayout.Y_AXIS));
        orderRecapList.setBackground(Color.WHITE);

        // Add padding to the order recap list
        orderRecapList.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Add the command lines to the list
        for (LigneC ligneC : client.listPizza) {
            JLabel ligneLabel = new JLabel(ligneC.pizza.nom + "(" + ligneC.taille + ") x" + ligneC.qte);
            ligneLabel.setFont(ligneLabel.getFont().deriveFont(Font.ITALIC));
            orderRecapList.add(ligneLabel);

            // Add space between the lines
            orderRecapList.add(Box.createRigidArea(new Dimension(0, 5)));
        }
        
        orderRecapPanel.add(orderRecapList, BorderLayout.CENTER);

        // Create a panel for the total price and the delete button
        JPanel totalPricePanel = new JPanel();
        totalPricePanel.setLayout(new BorderLayout());
        totalPricePanel.setBackground(Color.WHITE);

        // Create the total price label
        JLabel totalPriceLabel = new JLabel("Total: " + client.getCurrentCommandePrix() + "€");
        totalPriceLabel.setHorizontalAlignment(JLabel.CENTER);
        totalPriceLabel.setFont(totalPriceLabel.getFont().deriveFont(Font.BOLD));
        totalPricePanel.add(totalPriceLabel, BorderLayout.NORTH);

        // Create a delete button
        JButton deleteButton = new JButton("Delete");
        configureDeleteButton(deleteButton);

        // Add action listener to the delete button
        DeleteButtonListener deleteButtonListener = new DeleteButtonListener(this, client);
        deleteButton.addActionListener(deleteButtonListener);

        totalPricePanel.add(deleteButton, BorderLayout.CENTER);

        orderRecapPanel.add(totalPricePanel, BorderLayout.SOUTH);

        // Add the order recap panel to the main panel
        this.add(orderRecapPanel, BorderLayout.EAST);

        // Create the command button
        JButton orderButton = new JButton("Order");
        configureOrderButton(orderButton);

        // Add action listener to the order button
        OrderButtonListener orderButtonListener = new OrderButtonListener(this, client);
        orderButton.addActionListener(orderButtonListener);

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
    
        // Create a layout for the quantity and size
        JPanel quantitySizePanel = new JPanel(new GridBagLayout());
        quantitySizePanel.setBackground(Color.WHITE);
    
        // Create constraints for quantity text field
        GridBagConstraints quantityConstraints = new GridBagConstraints();
        quantityConstraints.weightx = 0.25; // 1/4 of the width
        quantityConstraints.fill = GridBagConstraints.HORIZONTAL;
        quantityConstraints.gridx = 0;
        quantityConstraints.gridy = 0;
        quantityConstraints.insets = new Insets(0, 0, 0, 5); 
    
        // Create text field for quantity
        JTextField quantityTextField = new JTextField();
        quantityTextField.setText("1");
        quantityTextField.setHorizontalAlignment(JTextField.CENTER);
        quantityTextField.setBackground(Color.WHITE);
        quantitySizePanel.add(quantityTextField, quantityConstraints);
    
        // Create constraints for size combo box
        GridBagConstraints sizeConstraints = new GridBagConstraints();
        sizeConstraints.weightx = 0.75; // 3/4 of the width
        sizeConstraints.fill = GridBagConstraints.HORIZONTAL;
        sizeConstraints.gridx = 1;
        sizeConstraints.gridy = 0;
    
        // Create combo box for pizza size
        JComboBox<String> sizeComboBox = new JComboBox<>(new String[] { "Naine", "Humaine", "Ogresse" });
        sizeComboBox.setSelectedIndex(1); 
        sizeComboBox.setFocusable(false);
        sizeComboBox.setBackground(Color.WHITE);
        quantitySizePanel.add(sizeComboBox, sizeConstraints);

        // Add the quantity and size panel to the main panel
        maiPanel.add(quantitySizePanel, BorderLayout.CENTER);
    
        card.add(maiPanel, BorderLayout.CENTER);
    
        // Add space between ingredients and select button
        maiPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
    
        // Create a select button
        JButton selectButton = new JButton("Select");
        configureSelectButton(selectButton);

        // Add action listener to the select button
        SelectButtonListener selectButtonListener = new SelectButtonListener(this, client, quantityTextField, sizeComboBox, titleLabel);
        selectButton.addActionListener(selectButtonListener);
    
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
        button.setFont(button.getFont().deriveFont(Font.BOLD, 16.0f));
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

    private void configureDeleteButton(JButton button) {
        button.setToolTipText("Delete the selected pizza");
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusable(false);
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(7, 0, 7, 0));
        button.setOpaque(true);
    }

    public Pizzeria getPizzeria() {
        return pizzeria;
    }

    public void refresh() {
        this.removeAll();
        ClientPanel clientPanel = new ClientPanel(client, pizzeria);
        this.setLayout(new BorderLayout());
        this.add(clientPanel);
        this.revalidate();
        this.repaint();
    }
}
