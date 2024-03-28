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

}