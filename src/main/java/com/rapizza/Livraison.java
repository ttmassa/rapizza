package com.rapizza;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
/**
 * 
 */
public class Livraison {
    /**
     * Attributes
     */
    public TypeVehicule vehicule;
    public int tempsLivraison;
    /**
     * Associations
     */
    public Commande commande;
    public Livreur livreur;

    /**
     * Default constructor
     */
    public Livraison(Commande commande, Livreur livreur) {
        this.commande = commande;
        this.livreur = livreur;

        // Generate a random time for the delivery between 5 and 50 minutes
        int random = (int) (Math.random() * 30) + 5;
        this.tempsLivraison = random;

        // 1 out of 3 chance to get a moto or a car
        this.vehicule = random % 3 == 0 ? TypeVehicule.voiture : TypeVehicule.moto;
    } 

    public void livrer() {
        if (!this.commande.isValide()) {
            return;
        }

        this.payer();

        // Create a timer to simulate the delivery
        Timer timer  = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (isLate()) {
                    JOptionPane.showMessageDialog(
                        null, 
                        "Order delivered !\n" + 
                        "Price : " + getPrixFinale() + "€\n" +
                        "Delivery time : " + tempsLivraison + " minutes\n" +
                        "Vehicle : " + vehicule.toString() + "\n" +
                        "Sorry we were late, free order !",
                        "YAYYY !",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                } else if (commande.client.getNbrCommandes() % 10 == 0 && commande.client.getNbrCommandes() != 0) {
                    JOptionPane.showMessageDialog(
                        null, 
                        "Order delivered !\n" + 
                        "Price : " + getPrixFinale() + "€\n" + 
                        "Delivery time : " + tempsLivraison + " minutes\n" + 
                        "Vehicle : " + vehicule.toString() + "\n" +
                        "Free order - thanks for your fidelity !",
                        "YAYYY !",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                        null, 
                        "Order delivered !\n" + 
                        "Price : " + getPrixFinale() + "€\n" + 
                        "Delivery time : " + tempsLivraison + " minutes" + 
                        "Vehicle : " + vehicule.toString(),
                        "YAYYY !",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
                livreur.isAvailable = true;
                timer.cancel();
            }
        };

        timer.schedule(task, this.tempsLivraison * 100);
    }

    public void payer() {
        this.commande.client.solde -= this.getPrixFinale();
    }

    public boolean isLate() {
        return this.tempsLivraison > 30;
    }

    public double getPrixFinale() {
        if (this.isLate()) {
            System.out.println("Retard de livraison (" + this.tempsLivraison + ") : Commande gratuite !");
            return 0;
        } else if (this.commande.client.getNbrCommandes() % 10 == 0 && this.commande.client.getNbrCommandes() != 0) {
            System.out.println("10 commandes chez nous : Commande gratuite !");
            return 0;
        } else {
            System.out.println("" + this.commande.getPrix());
            return this.commande.getPrix();
        }
    }
}