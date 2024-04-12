package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.rapizza.AuthentificationPanel;

public class LogoutButtonListener implements ActionListener {
    private JPanel parentPanel;

    public LogoutButtonListener(JPanel parentPanel) {
        this.parentPanel = parentPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (parentPanel != null) {
            parentPanel.removeAll();
            parentPanel.add(new AuthentificationPanel());
            parentPanel.revalidate();
            parentPanel.repaint();
        }
    }
}
