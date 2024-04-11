package com.rapizza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.rapizza.listeners.LogoutButtonListener;

public class AdminInfoPanel extends JPanel {
        
    public AdminInfoPanel() {
        // Set layout for the AdminPanel
        setLayout(new BorderLayout());

        // Create and add the toolbar to the top of the frame
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false); 
        toolBar.setBackground(Color.WHITE); 

        JButton infoButton = new JButton("Info");
        configureLinkButton(infoButton);
        toolBar.add(infoButton);

        // Logout button
        JButton logoutButton = new JButton("Logout");
        configureLinkButton(logoutButton);
        toolBar.add(logoutButton);

        LogoutButtonListener logoutButtonListener = new LogoutButtonListener(this);
        logoutButton.addActionListener(logoutButtonListener);

        add(toolBar, BorderLayout.NORTH);

        // Create the main panel
        JPanel mainPanel = new JPanel();

        add(mainPanel, BorderLayout.CENTER);

    }

    private void configureLinkButton(JButton button) {
        button.setForeground(Color.BLUE);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
    }

    public void showAuthentificationPanel() {
        removeAll();
        AuthentificationPanel authentificationPanel = new AuthentificationPanel();
        setLayout(new BorderLayout());
        add(authentificationPanel);
        revalidate();
        repaint();
    }

}
