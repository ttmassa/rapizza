package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.rapizza.Client;
import com.rapizza.ClientProfile;

public class ProfileButtonListener implements ActionListener {
    private JPanel parentPanel;
    private Client client;

    public ProfileButtonListener(JPanel parentPanel, Client client) {
        this.parentPanel = parentPanel;
        this.client = client;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (parentPanel != null) {
            // Show the ProfilePanel
            parentPanel.removeAll();
            parentPanel.add(new ClientProfile(client));
            parentPanel.revalidate();
            parentPanel.repaint();
        }
    }
    
}
