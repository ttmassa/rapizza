package com.rapizza;

import java.util.Vector;

/**
 * 
 */
public class Commande {
    /**
     * Attributes
     */
    static public int idCommande = 1;
    /**
     * Associations
     */
    public Client client;
    public Livraison livraison;
    public Vector<LigneC> listLigne;
    public Pizzeria pizzeria;

    /**
     * Default constructor
    */
    public Commande(Client client, Pizzeria pizzeria, Vector<LigneC> listPizza) {
        idCommande++;
        this.client = client;
        this.pizzeria = pizzeria;
        this.listLigne = listPizza;
        this.livraison = null;

        this.client.pizzeria.fabriquerCommande(this);
    }

    public double getPrix() {
        double prix = 0;

        for (LigneC ligne : this.listLigne) {
            prix += ligne.getPrix();
        }

        return Math.round(prix * 100.0) / 100.0;
    }

    public boolean isValide() {
        return this.client.solde >= this.getPrix();
    }

}