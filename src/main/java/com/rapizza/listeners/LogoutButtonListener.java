package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.rapizza.AdminInfoPanel;
import com.rapizza.AdminPanel;
import com.rapizza.ClientPanel;

public class LogoutButtonListener implements ActionListener {
    private AdminPanel adminPanel;
    private ClientPanel clientPanel;
    private AdminInfoPanel adminInfoPanel;

    public LogoutButtonListener(AdminPanel adminPanel) {
        this.adminPanel = adminPanel;
    }

    public LogoutButtonListener(ClientPanel clientPanel) {
        this.clientPanel = clientPanel;
    }

    public LogoutButtonListener(AdminInfoPanel adminInfoPanel) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (adminPanel != null) {
            adminPanel.showAuthentificationPanel();
        } else if (clientPanel != null) {
            clientPanel.showAuthentificationPanel();
        } else if (adminInfoPanel != null) {
            adminInfoPanel.showAuthentificationPanel();
        }
    }
}
