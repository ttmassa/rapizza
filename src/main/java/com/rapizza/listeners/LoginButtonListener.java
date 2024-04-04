package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.rapizza.AuthentificationPanel;

public class LoginButtonListener implements ActionListener {

    private AuthentificationPanel authPanel;

    public LoginButtonListener(AuthentificationPanel authPanel) {
        this.authPanel = authPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check which radio button is selected
        if (authPanel.isClientSelected()) {
            // Show the ClientPanel
            authPanel.showClientPanel();
        } else if (authPanel.isAdminSelected()) {
            // Show the AdminPanel
            authPanel.showAdminPanel();
        } 
    }
}
