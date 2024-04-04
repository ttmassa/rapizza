package com.rapizza;

import java.awt.BorderLayout;

import javax.swing.JButton;
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
        JButton commandButton = new JButton("Command");
        commandButton.setToolTipText("Make a new command");
        commandButton.setBorderPainted(false);
        commandButton.setFocusable(false);
        JButton settingsButton = new JButton("Settings");
        settingsButton.setToolTipText("Change settings");
        settingsButton.setBorderPainted(false);
        settingsButton.setFocusable(false);

        // Add the buttons to the toolbar
        toolbar.add(commandButton);
        toolbar.add(settingsButton);

        this.add(toolbar, BorderLayout.NORTH);

    }

}
