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

}