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

            // Create the main panel
            MainPanel mainPanel = new MainPanel();
            mainWindow.add(mainPanel);

            // Display the main window
            mainWindow.setVisible(true);
        });

    }
}
