package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.rapizza.AdminPanel;
import com.rapizza.ClientPanel;

public class LogoutButtonListener implements ActionListener {
    private AdminPanel adminPanel;
    private ClientPanel clientPanel;

    public LogoutButtonListener(AdminPanel adminPanel) {
        this.adminPanel = adminPanel;
    }

    public LogoutButtonListener(ClientPanel clientPanel) {
        this.clientPanel = clientPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (adminPanel != null) {
            adminPanel.showAuthentificationPanel();
        } else if (clientPanel != null) {
            clientPanel.showAuthentificationPanel();
        }
    }
}
