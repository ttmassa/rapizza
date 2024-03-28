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

    public boolean isLate() {
        return this.tempsLivraison > 30;
    }

    public double getPrixFinale() {
        if (this.isLate()) {
            return 0;
        } else {
            return this.commande.getPrix();
        }
    }
}