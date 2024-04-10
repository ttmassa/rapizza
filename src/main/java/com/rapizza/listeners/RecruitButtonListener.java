package com.rapizza.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.rapizza.AdminPanel;
import com.rapizza.Livreur;
import com.rapizza.Pizzeria;

public class RecruitButtonListener implements ActionListener {
    private JComboBox<String> listPizzerias;
    private AdminPanel adminPanel;

    public RecruitButtonListener(JComboBox<String> listPizzerias, AdminPanel adminPanel) {
        this.listPizzerias = listPizzerias;
        this.adminPanel = adminPanel;

    }

    /*
     * This method is called whenever the button is clicked
     * It should recruit a new employee for the selected pizzeria 
     * using recruterLivreur() method from Pizzeria class
     * To do so, you need to get the pizzeria address from the selected item
     * Then, find the pizzeria with the given address
     * Finally, create a new employee and add it to the pizzeria
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the selected pizzeria
        String address = (String) listPizzerias.getSelectedItem();
        Pizzeria pizzeria = Pizzeria.listPizzerias.stream().filter(p -> p.adresse.equals(address)).findFirst().get();

        // Create a new employee
        Livreur livreur = new Livreur(pizzeria);

        // Recruit a new employee
        pizzeria.recruterLivreur(livreur);

        // Refresh the panel
        adminPanel.refreshPanel();

        // Display a success message
        JOptionPane.showMessageDialog(null, "Employee recruited successfully");
    }
}
