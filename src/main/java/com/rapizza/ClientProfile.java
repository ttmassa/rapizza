package com.rapizza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.rapizza.listeners.CommandsButtonListener;
import com.rapizza.listeners.LogoutButtonListener;
import com.rapizza.listeners.RechargeButtonListener;

public class ClientProfile extends JPanel {
    private Client client;

    public ClientProfile(Client client) {
        this.client = client;

        // Set layout to BorderLayout
        this.setLayout(new BorderLayout());

        // Toolbar (Commands and Settings)
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        // Create the buttons
        JButton commandButton = new JButton("Commands");
        commandButton.setToolTipText("Make a new order");
        configureLinkButton(commandButton);

        // Add action listener to the command button
        CommandsButtonListener commandsButtonListener = new CommandsButtonListener(this);
        commandButton.addActionListener(commandsButtonListener);

        JButton profileButton = new JButton("Profile");
        profileButton.setToolTipText("View your profile");
        configureLinkButton(profileButton);

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
        mainPanel.setLayout(new GridLayout(4, 1));

        // Display the phone number
        JLabel phoneNumberLabel = new JLabel("Phone number: " + client.getNumTelephone());
        phoneNumberLabel.setFont(new java.awt.Font("Arial", Font.PLAIN, 20));
        mainPanel.add(phoneNumberLabel);

        // Display the sold amount

        // Create a new panel to align the sold amount and the button to recharge the account
        JPanel soldAmountPanel = new JPanel();
        soldAmountPanel.setLayout(new BorderLayout());

        // Create a label to display the sold amount
        JLabel soldAmountLabel = new JLabel("Sold amount: " + client.getSolde() + " €");
        soldAmountLabel.setFont(new java.awt.Font("Arial", Font.PLAIN, 20));
        soldAmountPanel.add(soldAmountLabel, BorderLayout.WEST);

        // Create a text field to enter the amount to recharge
        JTextField rechargeAmountField = new JTextField();
        rechargeAmountField.setToolTipText("Enter the amount to recharge");
        rechargeAmountField.setFont(new java.awt.Font("Arial", Font.PLAIN, 20));
        soldAmountPanel.add(rechargeAmountField, BorderLayout.CENTER);

        // Create a button to recharge the account
        JButton rechargeButton = new JButton("Recharge");
        rechargeButton.setToolTipText("Recharge your account");
        configureLinkButton(rechargeButton);

        // Add action listener to the recharge button
        RechargeButtonListener rechargeButtonListener = new RechargeButtonListener(this, client, rechargeAmountField);
        rechargeButton.addActionListener(rechargeButtonListener);

        // Add action listener to the recharge button

        // Add the recharge button to the panel
        soldAmountPanel.add(rechargeButton, BorderLayout.EAST);

        mainPanel.add(soldAmountPanel);

        // Display the number of orders
        JLabel ordersLabel = new JLabel("Number of orders: " + client.getNbrCommandes());
        ordersLabel.setFont(new java.awt.Font("Arial", Font.PLAIN, 20));
        mainPanel.add(ordersLabel);        

        // Add the main panel to the center of the frame
        this.add(mainPanel, BorderLayout.CENTER);
    }

    private void configureLinkButton(JButton button) {
        button.setForeground(Color.BLUE);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
    }
    
    public Client getClient() {
        return client;
    }


    public void refresh() {
        this.removeAll();
        ClientProfile newProfile = new ClientProfile(this.client);
        this.add(newProfile);
        this.revalidate();
        this.repaint();
    }

}
