package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.rapizza.AuthentificationPanel;

public class LoginButtonListener implements ActionListener {

    private AuthentificationPanel authPanel;

    public LoginButtonListener(AuthentificationPanel authPanel) {
        this.authPanel = authPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (authPanel.isRadioSelected() && authPanel.getPhoneNumberListener().isFilled()) {
            // Check which radio button is selected
            if (authPanel.isClientSelected()) {
                // Show the ClientPanel
                authPanel.showClientPanel();
            } else if (authPanel.isAdminSelected()) {
                // Show the AdminPanel
                authPanel.showAdminPanel();
            } 
        } else {
            JOptionPane.showMessageDialog(null, "Please fill in a valid phone number and sleect a user type");
            System.out.println("Please fill in a valid phone number and sleect a user type");
        }
    }
}
