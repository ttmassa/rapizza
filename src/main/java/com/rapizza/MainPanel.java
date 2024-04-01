package com.rapizza;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel {
    public MainPanel() {
        JTextField textArea = new JTextField("Rapizza");
        
        add(textArea);
    }
}