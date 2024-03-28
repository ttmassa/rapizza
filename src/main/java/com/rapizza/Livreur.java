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

}