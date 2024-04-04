package com.rapizza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.rapizza.listeners.LogoutButtonListener;

public class ClientPanel extends JPanel {
    
    public ClientPanel() {
        // Set layout to BorderLayout
        this.setLayout(new BorderLayout());
        
        // Toolbar (Commands and Settings)
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        // Create the buttons
        JLabel commandButton = new JLabel("Commands");
        commandButton.setToolTipText("Make a new order");
        configureLinkLabel(commandButton);

        JLabel settingsButton = new JLabel("Settings");
        settingsButton.setToolTipText("Change your settings");
        configureLinkLabel(settingsButton);

        // Create logout button
        JButton logoutButton = new JButton("Logout");
        configureLinkButton(logoutButton);

        LogoutButtonListener logoutButtonListener = new LogoutButtonListener(this);
        logoutButton.addActionListener(logoutButtonListener);

        // Add the buttons to the toolbar
        toolbar.add(commandButton);
        toolbar.addSeparator();
        toolbar.add(settingsButton);
        toolbar.addSeparator();
        toolbar.add(logoutButton);

        this.add(toolbar, BorderLayout.NORTH);


    }

    private void configureLinkLabel(JLabel label) {
        label.setForeground(Color.BLUE);
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.setFocusable(false);
    }

    private void configureLinkButton(JButton button) {
        button.setForeground(Color.BLUE);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
    }

    // Not good because it's used in multiple classes
    public void showAuthentificationPanel() {
        removeAll();
        AuthentificationPanel authentificationPanel = new AuthentificationPanel();
        setLayout(new BorderLayout());
        add(authentificationPanel);
        revalidate();
        repaint();
    }

}
