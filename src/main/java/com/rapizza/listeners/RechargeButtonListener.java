package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.rapizza.Client;
import com.rapizza.ClientProfile;

public class RechargeButtonListener implements ActionListener {
    private ClientProfile parentPanel;
    private Client client;
    private JTextField textAmount;

    public RechargeButtonListener(ClientProfile parentPanel, Client client, JTextField textAmount) {
        this.parentPanel = parentPanel;
        this.client = client;
        this.textAmount = textAmount;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the price 
        double amount = textAmount.getText().isEmpty() ? 0 : Double.parseDouble(textAmount.getText());

        if (amount <= 0) {
            JOptionPane.showMessageDialog(
                this.parentPanel, 
                "You cannot recharge a negative textAmount!", 
                "Error", 
                JOptionPane.ERROR_MESSAGE
            );
        } else {
            this.client.recharger(amount);
        }

        // Refresh the panel
        this.parentPanel.refresh();
    }
    
}
