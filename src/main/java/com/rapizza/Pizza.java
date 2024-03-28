package com.rapizza;

import java.util.*;

/**
 * 
 */
public class Pizza {
    /**
     * Attributes
     */
    public String nom;
    public String[] ingredients;
    public double prixBase;
    /**
     * Associations
     */
    public Client client;
    public Pizzeria pizzeria;
    public Vector<LigneRecette> listLigneR;
    public Vector<LigneC> listLigne;


    /**
     * Default constructor
     */
    public Pizza(String nom, String[] ingredients, double prixBase, Client client, Pizzeria pizzeria) {
        this.nom = nom;
        this.ingredients = ingredients;
        this.prixBase = prixBase;
        this.client = client;
        this.pizzeria = pizzeria;
        this.listLigneR = new Vector<LigneRecette>();
        this.listLigne = new Vector<LigneC>();
    }

}