package com.rapizza;

import java.util.*;

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
        this.client.pizzeria.fabriquerCommande(this);
    }

    public double getPrix() {
        double prix = 0;

        for (LigneC ligne : this.listLigne) {
            prix += ligne.getPrix();
        }

        return prix;
    }

    public boolean isValide() {
        return this.client.solde >= this.getPrix();
    }

    public void payer() {
        if (this.isValide()) {
            this.client.solde -= this.livraison.getPrixFinale();
            this.pizzeria.listClient.get(this.client.numTelephone).nbrCommande++;
        }
    }

}