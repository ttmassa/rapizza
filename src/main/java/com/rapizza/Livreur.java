package com.rapizza;

import java.util.*;

/**
 * 
 */
public class Livreur {
    /**
     * Attributes
     */
    public int idLivreur;
    public boolean isAvailable = true;
    /**
     * Associations
     */
    public Vector<Livraison> listLivraison;
    public Pizzeria pizzeria;

    /**
     * Default constructor
     */
    public Livreur(int idLivreur, Pizzeria pizzeria) {
        this.idLivreur = idLivreur;
        this.listLivraison = new Vector<Livraison>();
        this.pizzeria = pizzeria;
    }

    public void affecterLivraison(Commande commande) {
        Livraison livraison = new Livraison(commande, this);
        this.listLivraison.add(livraison);
        this.isAvailable = false;

        // Start the delivery
        livraison.livrer();
    }



}