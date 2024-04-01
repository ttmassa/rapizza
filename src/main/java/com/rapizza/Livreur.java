package com.rapizza;

import java.util.Vector;

/**
 * 
 */
public class Livreur {
    /**
     * Attributes
     */
    static int idLivreur = 0;
    public boolean isAvailable = true;
    /**
     * Associations
     */
    public Vector<Livraison> listLivraison;
    public Pizzeria pizzeria;

    /**
     * Default constructor
     */
    public Livreur(Pizzeria pizzeria) {
        idLivreur++;
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