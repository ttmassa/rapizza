package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.rapizza.ClientPanel;
import com.rapizza.ClientProfile;

public class CommandsButtonListener implements ActionListener {
    private ClientProfile parentPanel;

    public CommandsButtonListener(ClientProfile parentPanel) {
        this.parentPanel = parentPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.parentPanel != null) {
            parentPanel.removeAll();
            ClientPanel clientPanel = new ClientPanel(parentPanel.getClient(), parentPanel.getClient().pizzeria);
            parentPanel.add(clientPanel);
            parentPanel.revalidate();
            parentPanel.repaint();
        }
        
    }
}