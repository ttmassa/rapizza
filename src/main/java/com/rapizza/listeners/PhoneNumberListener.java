package com.rapizza.listeners;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PhoneNumberListener implements DocumentListener {
    private JTextField phoneNumberTextField;
    private boolean isFilled;

    public PhoneNumberListener(JTextField phoneNumberTextField) {
        this.phoneNumberTextField = phoneNumberTextField;
        this.isFilled = false;
        this.phoneNumberTextField.getDocument().addDocumentListener(this);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateState();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateState();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateState();
    }

    public boolean isFilled() {
        return isFilled;
    }

    private void updateState() {
        isFilled = !phoneNumberTextField.getText().isEmpty();
    }

    public String getPhoneNumber() {
        return phoneNumberTextField.getText();
    }

    public boolean isValid() {
        // Every phone number must have 10 digits and no letters
        String phoneNumber = phoneNumberTextField.getText();
        return phoneNumber.length() == 10 && phoneNumber.matches("[0-9]+");
    }
}
