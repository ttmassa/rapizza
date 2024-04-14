package com.rapizza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.rapizza.listeners.LogoutButtonListener;

public class ClientProfile extends JPanel {

    public ClientProfile(Client client) {

        // Set layout to BorderLayout
        this.setLayout(new BorderLayout());

        // Toolbar (Commands and Settings)
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        // Create the buttons
        JButton commandButton = new JButton("Commands");
        commandButton.setToolTipText("Make a new order");
        configureLinkButton(commandButton);

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
        JLabel soldAmountLabel = new JLabel("Sold amount: " + client.getSolde() + " €");
        soldAmountLabel.setFont(new java.awt.Font("Arial", Font.PLAIN, 20));
        mainPanel.add(soldAmountLabel);

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

}
