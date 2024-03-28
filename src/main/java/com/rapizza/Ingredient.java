package com.rapizza;

import java.util.*;

/**
 * 
 */
public class Ingredient {
    /**
     * Attributes
     */
    public String nom;
    public double prixKg;
    /**
     * Associations
     */
    public Vector<LigneRecette> listIngr;


    /**
     * Default constructor
     */
    public Ingredient(String nom, double prixKg) {
        this.nom = nom;
        this.prixKg = prixKg;
        this.listIngr = new Vector<LigneRecette>();
    }

}