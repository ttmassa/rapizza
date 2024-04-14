package com.rapizza.listeners;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.rapizza.AuthentificationPanel;
import com.rapizza.Client;
import com.rapizza.ClientPanel;

public class LoginButtonListener implements ActionListener {

    private AuthentificationPanel authPanel;

    public LoginButtonListener(AuthentificationPanel authPanel) {
        this.authPanel = authPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if the radio button is selected and the phone number is filled
        if (authPanel.isRadioSelected() && authPanel.getPhoneNumberListener().isValid()) {
            // Check which radio button is selected
            if (authPanel.isClientSelected()  && authPanel.getPizzeriaSelected() != null ) {
                // Show the ClientPanel
                Client client = new Client(authPanel.getPhoneNumberListener().getPhoneNumber(), authPanel.getPizzeriaSelected());
                showClientPanel(client);
                authPanel.getPizzeriaSelected().ajouterClient(client);
            } else if (authPanel.isAdminSelected()) {
                // Show the AdminPanel
                authPanel.showAdminPanel();
            } 
        } else {
            // Display an error message
            JOptionPane.showMessageDialog(null, "Please fill in a valid phone number, sleect a user type and a pizzeria");
            System.out.println("Please fill in a valid phone number and sleect a user type");
        }
    }

    public void showClientPanel(Client client) {
        authPanel.removeAll();
        ClientPanel clientPanel = new ClientPanel(client, authPanel.getPizzeriaSelected());
        authPanel.setLayout(new BorderLayout());
        authPanel.add(clientPanel);
        authPanel.revalidate();
        authPanel.repaint();
    }

}
