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
    public Vector<Ingredient> ingredients;
    public double prixMarge;
    
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
    public Pizza(String nom, Vector <Ingredient> ingredients, double prixMarge, Client client, Pizzeria pizzeria) {
        this.nom = nom;
        this.prixMarge = prixMarge;
        this.client = client;
        this.pizzeria = pizzeria;
        this.ingredients = new Vector<Ingredient>();
        this.listLigneR = new Vector<LigneRecette>();
        this.listLigne = new Vector<LigneC>();
    }

    public Pizza(String nom, double prixMarge, Vector <Ingredient> ingredients) {
        this.nom = nom;
        this.prixMarge = prixMarge;
        this.ingredients = ingredients;
        this.listLigneR = new Vector<LigneRecette>();
        this.listLigne = new Vector<LigneC>();
    }
    
    public double getPrix() {
        double prix = this.prixMarge;

        for (LigneRecette ligne : this.listLigneR) {
            prix += ligne.getPrix();
        }

        return prix;
    }

}