package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.rapizza.Client;
import com.rapizza.ClientPanel;

public class OrderButtonListener implements ActionListener {
    private ClientPanel parentPanel;
    private Client client;

    public OrderButtonListener(ClientPanel parentPanel, Client client) {
        this.parentPanel = parentPanel;
        this.client = client;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Order the pizzas
        if (this.client.getCurrentCommandePrix() > this.client.solde) {
            JOptionPane.showMessageDialog(
                parentPanel, 
                "You do not have enough money to place this order! Please add more money to your account in the profile section.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE
            );
        } else if (this.client.pizzeria.listLivreur.isEmpty()) {
            JOptionPane.showMessageDialog(
                parentPanel, 
                "We do not have any delivery drivers yet - please recruit some first in the admin section!", 
                "Error", 
                JOptionPane.ERROR_MESSAGE
            );
        } else {
            this.client.passerCommande();
        }

        // Refresh the panel
        parentPanel.refresh();
    }
}
