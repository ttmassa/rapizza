package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.rapizza.AdminPanel;

public class DashboardButtonListener implements ActionListener {
    private JPanel parentPanel;

    public DashboardButtonListener(JPanel parentPanel) {
        this.parentPanel = parentPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (parentPanel != null) {
            // Show the AdminInfoPanel
            parentPanel.removeAll();
            parentPanel.add(new AdminPanel());
            parentPanel.revalidate();
            parentPanel.repaint();
        }
    }
}
