package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        client.passerCommande();

        // Refresh the panel
        parentPanel.refresh();
    }
}
