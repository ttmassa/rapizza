package com.rapizza;

import java.util.Timer;
import java.util.TimerTask;
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
    public Livraison(Commande commande, Livreur livreur, TypeVehicule vehicule, int tempsLivraison) {
        this.commande = commande;
        this.livreur = livreur;
        this.vehicule = vehicule;
        this.tempsLivraison = tempsLivraison;
    }

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
            System.out.println("Solde insuffisant");
            return;
        }
        this.payer();

        // Set the delivery in progress
        System.out.println("Commande en cours de livraison");

        // Create a timer to simulate the delivery
        Timer timer  = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Commande livrée");
                System.out.println("Nouveau solde client : " + commande.client.solde + " euros");
                livreur.isAvailable = true;
                timer.cancel();
            }
        };

        timer.schedule(task, this.tempsLivraison * 10);
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
        } else if (this.commande.client.nbrCommande % 10 == 0 && this.commande.client.nbrCommande != 0) {
            System.out.println("10 commandes chez nous : Commande gratuite !");
            return 0;
        } else {
            return this.commande.getPrix();
        }
    }
}