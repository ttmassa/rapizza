package com.rapizza;

import java.util.*;

/**
 * 
 */
public class Pizzeria {
    /**
     * Attributes
     */
    public String adresse;
    /**
     * Associations
     */
    public Vector<Client> listClient;
    public Vector<Pizza> menu;
    public Vector<Commande> listCo;
    public Vector<Livreur> listLivreur;


    /**
     * Default constructor
     */
    public Pizzeria(String adresse) {
        this.adresse = adresse;
        this.listClient = new Vector<Client>();
        this.menu = new Vector<Pizza>();
        this.listCo = new Vector<Commande>();
        this.listLivreur = new Vector<Livreur>();
    }

}