package com.rapizza;

import java.util.*;

/**
 * 
 */
public class Commande {
    /**
     * Attributes
     */
    public int idCommande;
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
    public Commande(int idCommande, Client client, Livraison livraison, Pizzeria pizzeria) {
        this.idCommande = idCommande;
        this.listLigne = new Vector<LigneC>();
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