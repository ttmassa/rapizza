package com.rapizza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.rapizza.listeners.DashboardButtonListener;
import com.rapizza.listeners.LogoutButtonListener;

public class AdminInfoPanel extends JPanel {

    public AdminInfoPanel() {
        setLayout(new BorderLayout());

        // Create and add the toolbar to the top of the frame
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setBackground(Color.WHITE);

        // Dashboard button
        JButton dashboardButton = new JButton("Dashboard");
        configureLinkButton(dashboardButton);
        toolBar.add(dashboardButton);

        // Add a listener to the dashboard button
        dashboardButton.addActionListener(new DashboardButtonListener(this));

        JButton infoButton = new JButton("Info");
        configureLinkButton(infoButton);
        toolBar.add(infoButton);

        // Help me button
        JButton helpButton = new JButton("Help");
        configureLinkButton(helpButton);
        toolBar.add(helpButton);

        // Logout button
        JButton logoutButton = new JButton("Logout");
        configureLinkButton(logoutButton);
        toolBar.add(logoutButton);

        LogoutButtonListener logoutButtonListener = new LogoutButtonListener(this);
        logoutButton.addActionListener(logoutButtonListener);

        add(toolBar, BorderLayout.NORTH);

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout()); // Set layout for main panel

        // Create the combo box
        JComboBox<String> pizzeriaComboBox = new JComboBox<String>();

        // Get the list of pizzerias from the database
        if (Pizzeria.listPizzerias.isEmpty()) {
            pizzeriaComboBox.addItem("No pizzerias found - please add one.");
        } else {
            pizzeriaComboBox.addItem("Select a pizzeria");

            for (Pizzeria pizzeria : Pizzeria.listPizzerias) {
                pizzeriaComboBox.addItem(pizzeria.adresse);
            }
        }

        // Add the combo box to the main panel
        mainPanel.add(pizzeriaComboBox, BorderLayout.NORTH);

        // Add a listener to the combo box
        pizzeriaComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected pizzeria
                int selectedIndex = pizzeriaComboBox.getSelectedIndex();
                System.out.println("Selected index: " + selectedIndex);
                if (selectedIndex > 0) {
                    Pizzeria selectedPizzeria = Pizzeria.listPizzerias.get(selectedIndex - 1);

                    // Create a new panel with the selected pizzeria
                    JPanel pizzeriaPanel = new JPanel();
                    pizzeriaPanel.setLayout(new GridLayout(4, 1));

                    // Create a label with the number of clients
                    JLabel clientsLabel = new JLabel("Number of clients: " + selectedPizzeria.listClient.size());
                    clientsLabel.setHorizontalAlignment(JLabel.CENTER);
                    clientsLabel.setFont(new Font("Arial", Font.BOLD, 16));
                    pizzeriaPanel.add(clientsLabel);

                    // Create a label with the number of orders
                    JLabel ordersLabel = new JLabel("Number of orders: " + selectedPizzeria.listCo.size());
                    ordersLabel.setHorizontalAlignment(JLabel.CENTER);
                    ordersLabel.setFont(new Font("Arial", Font.BOLD, 16));
                    pizzeriaPanel.add(ordersLabel);

                    // Create a label with the number of employees
                    JLabel employeesLabel = new JLabel("Number of employees: " + selectedPizzeria.listLivreur.size());
                    employeesLabel.setHorizontalAlignment(JLabel.CENTER);
                    employeesLabel.setFont(new Font("Arial", Font.BOLD, 16));
                    pizzeriaPanel.add(employeesLabel);

                    // Create a combo box with the menu
                    JComboBox<String> menuComboBox = new JComboBox<String>();

                    if (selectedPizzeria.menu.isEmpty()) {
                        menuComboBox.addItem("No pizzas found - please add one.");
                    } else {
                        menuComboBox.addItem("Select a pizza");

                        for (Pizza pizza : selectedPizzeria.menu) {
                            menuComboBox.addItem(pizza.nom + " - " + pizza.prixMarge + "€");
                        }
                    }

                    // Create a panel to contain the combo box and center it
                    JPanel comboPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    comboPanel.add(menuComboBox);

                    // Add the combo box panel to the main panel
                    pizzeriaPanel.add(comboPanel);

                    // Add the panel to the main panel
                    mainPanel.add(pizzeriaPanel, BorderLayout.CENTER);

                    // Repaint the main panel
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }   
            }
        });

        // Add the main panel to the AdminPanel
        add(mainPanel, BorderLayout.CENTER);
    }

    private void configureLinkButton(JButton button) {
        button.setForeground(Color.BLUE);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
    }

    public void showAuthentificationPanel() {
        removeAll();
        AuthentificationPanel authentificationPanel = new AuthentificationPanel();
        setLayout(new BorderLayout());
        add(authentificationPanel);
        revalidate();
        repaint();
    }
}
