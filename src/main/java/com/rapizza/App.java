package com.rapizza;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            // Create the main window
            JFrame mainWindow = new JFrame("Rapizza");
            mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainWindow.setSize(800, 600);

            // // Create the main panel
            // AuthentificationPanel mainPanel = new AuthentificationPanel();
            // mainWindow.add(mainPanel);
            // mainWindow.setLocationRelativeTo(null);

            // Create the admin panel
            AdminPanel adminPanel = new AdminPanel();
            mainWindow.getContentPane().add(adminPanel);

            // Display the main window
            mainWindow.setVisible(true);
        });

    }
}
