package com.rapizza;

import javax.swing.*;
import java.awt.*;

import com.rapizza.listeners.CommandsButtonListener;
import com.rapizza.listeners.LogoutButtonListener;
import com.rapizza.listeners.RechargeButtonListener;

public class ClientProfile extends JPanel {
    private Client client;

    private static final int LINE_WIDTH = Integer.MAX_VALUE;
    private static final int LINE_HEIGHT = 50;

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
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Panel for phone number
        JPanel phoneNumberPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        phoneNumberPanel.setMaximumSize(new Dimension(LINE_WIDTH, LINE_HEIGHT + 20));
        JLabel phoneNumberLabel = new JLabel("Phone number: " + client.getNumTelephone());
        phoneNumberLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        phoneNumberPanel.add(phoneNumberLabel);

        // Add top margin to the panel
        phoneNumberPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        mainPanel.add(phoneNumberPanel);

        // Panel for sold amount and recharge button
        JPanel soldAmountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        soldAmountPanel.setMaximumSize(new Dimension(LINE_WIDTH, LINE_HEIGHT));
        JLabel soldAmountLabel = new JLabel("Sold amount: " + client.getSolde() + " €");
        soldAmountLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        soldAmountPanel.add(soldAmountLabel);

        // Add space between the label and the recharge button
        soldAmountPanel.add(Box.createHorizontalStrut(10));

        JPanel rechargePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Create the text field for the recharge amount
        JTextField rechargeAmountField = new JTextField();
        rechargeAmountField.setToolTipText("Enter the amount to recharge");
        rechargeAmountField.setFont(new Font("Arial", Font.PLAIN, 20));
        rechargeAmountField.setPreferredSize(new Dimension(100, 30));
        rechargePanel.add(rechargeAmountField);

        // Add space between the text field and the recharge button
        rechargePanel.add(Box.createHorizontalStrut(10));

        // Create the recharge button
        JButton rechargeButton = new JButton("Recharge");
        rechargeButton.setToolTipText("Recharge your account");
        configureRechargeButton(rechargeButton);
        
        // Add action listener to the recharge button
        RechargeButtonListener rechargeButtonListener = new RechargeButtonListener(this, client, rechargeAmountField);
        rechargeButton.addActionListener(rechargeButtonListener);

        rechargePanel.add(rechargeButton);

        soldAmountPanel.add(rechargePanel); // Add the recharge panel to the soldAmountPanel
        mainPanel.add(soldAmountPanel);

        // Panel for number of orders
        JPanel ordersPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ordersPanel.setMaximumSize(new Dimension(LINE_WIDTH, LINE_HEIGHT));
        JLabel ordersLabel = new JLabel("Number of orders: " + client.getNbrCommandes());
        ordersLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        ordersPanel.add(ordersLabel);
        mainPanel.add(ordersPanel);

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

    private void configureRechargeButton(JButton button) {
        button.setBackground(Color.BLUE);
        button.setOpaque(true);
        button.setForeground(Color.WHITE);
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
