package com.rapizza;

import java.util.*;

/**
 * 
 */
public class Commande {

    /**
     * Default constructor
     */
    public Commande() {
    }

    /**
     * 
     */
    public int idCommande;

    /**
     * 
     */
    public Client client;

    /**
     * 
     */
    public Livraison livraison;

    /**
     * 
     */
    public Set<LigneC> listLigne;

    /**
     * 
     */
    public Pizzeria pizzeria;

}