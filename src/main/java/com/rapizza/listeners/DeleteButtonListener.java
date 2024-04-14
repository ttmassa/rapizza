package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.rapizza.Client;
import com.rapizza.ClientPanel;

public class DeleteButtonListener implements ActionListener {
    private ClientPanel parentPanel;
    private Client client;

    public DeleteButtonListener(ClientPanel parentPanel, Client client) {
        this.parentPanel = parentPanel;
        this.client = client;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        client.effacerLignes();

        // Refresh the panel
        parentPanel.refresh();
    }
}
