package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.rapizza.AuthentificationPanel;
import com.rapizza.Client;

public class LoginButtonListener implements ActionListener {

    private AuthentificationPanel authPanel;

    public LoginButtonListener(AuthentificationPanel authPanel) {
        this.authPanel = authPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if the radio button is selected and the phone number is filled
        if (authPanel.isRadioSelected() ) {
            // Check which radio button is selected
            if (authPanel.isClientSelected()) {
                // Show the ClientPanel
                authPanel.showClientPanel();
                Client client = new Client(authPanel.getPhoneNumberListener().getPhoneNumber(), authPanel.getPizzeria());
                System.out.println("Client created: " + client.pizzeria);
            } else if (authPanel.isAdminSelected()) {
                // Show the AdminPanel
                authPanel.showAdminPanel();
            } 
        } else {
            // Display an error message
            JOptionPane.showMessageDialog(null, "Please fill in a valid phone number and sleect a user type");
            System.out.println("Please fill in a valid phone number and sleect a user type");
        }
    }
}
