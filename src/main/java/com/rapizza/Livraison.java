package com.rapizza;


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
        System.out.println("Commande livrée");
        this.livreur.isAvailable = true;
    }

    public void payer() {
        this.commande.client.solde -= this.getPrixFinale();
        this.commande.pizzeria.listClient.get(this.commande.client.numToInt()).nbrCommande++;
    }

    public boolean isLate() {
        return this.tempsLivraison > 30;
    }

    public double getPrixFinale() {
        if (this.isLate() || this.commande.client.nbrCommande > 10) {
            System.out.println("Commande gratuite");
            return 0;
        } else {
            return this.commande.getPrix();
        }
    }
}