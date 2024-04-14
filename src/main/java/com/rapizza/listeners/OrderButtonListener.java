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
        if (this.client.pizzeria.listLivreur.isEmpty()) {
            JOptionPane.showMessageDialog(
                parentPanel, 
                "Oh no! We do not have any delivery drivers yet - please recruit some first in the admin section!", 
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
