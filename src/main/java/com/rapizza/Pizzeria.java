package com.rapizza;

import java.util.*;

/**
 * 
 */
public class Pizzeria {
    public String adresse;
    public Vector<Client> listClient;
    public Vector<Pizza> menu;
    public Vector<Commande> listCo;
    public Vector<Livreur> listLivreur;


    /**
     * Default constructor
     */
    public Pizzeria(String adresse) {
        this.adresse = adresse;
    }

}