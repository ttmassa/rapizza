package com.rapizza;

import javax.swing.*;
import java.awt.*;

public class AddPizzaPanel extends JPanel {

    public AddPizzaPanel() {
        /*
         * Set layout to GridLayout
         * Create the form similar to the one in AuthenticationPanel
         * Add the form to the panel
         */

        this.setLayout(new GridLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create label for "Name"
        JLabel nameLabel = new JLabel("Name");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START; // Aligner à gauche
        nameLabel.isCursorSet();

        add(nameLabel, gbc);

        // Create the name text field
        JTextField nameTextField = new JTextField();
        nameTextField.setPreferredSize(new Dimension(150, 24));
        nameTextField.setHorizontalAlignment(JTextField.CENTER);

        // Add the text field to the center of the panel
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(nameTextField, gbc);
        

    }

    public void show() {
        // No need to create another instance of AddPizzaPanel, just repainting is enough
        revalidate();
        repaint();
    }

    public void hide() {
        removeAll();
        AdminPanel adminPanel = new AdminPanel();
        setLayout(new BorderLayout());
        add(adminPanel);
        revalidate();
        repaint();
    }
}
