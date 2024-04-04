package com.rapizza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ClientPanel extends JPanel {
    
    public ClientPanel() {
        // Set layout to BorderLayout
        this.setLayout(new BorderLayout());
        
        // Toolbar (Commands and Settings)
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);
        toolbar.addSeparator();

        // Create the buttons
        JLabel commandButton = new JLabel("Commands");
        commandButton.setToolTipText("Make a new order");
        configureLinkLabel(commandButton);

        JLabel settingsButton = new JLabel("Settings");
        settingsButton.setToolTipText("Change your settings");
        configureLinkLabel(settingsButton);

        // Add the buttons to the toolbar
        toolbar.add(commandButton);
        toolbar.add(settingsButton);

        this.add(toolbar, BorderLayout.NORTH);

    }

    private void configureLinkLabel(JLabel label) {
        label.setForeground(Color.BLUE);
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.setFocusable(false);
    }

}
