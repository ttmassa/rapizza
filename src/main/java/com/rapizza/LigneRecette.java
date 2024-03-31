package com.rapizza;


/**
 * 
 */
public class LigneRecette {
    /**
     * Attributes
     */
    public double qte;
    /**
     * Associations
     */
    public Pizza pizza;
    public Ingredient ingr;

    /**
     * Default constructor
     */
    public LigneRecette(Pizza pizza, Ingredient ingr, double qte) {
        this.pizza = pizza;
        this.qte = qte;
        this.ingr = ingr;
    }

    public double getPrix() {
        return this.qte * this.ingr.prixKg;
    }

    public String toString() {
        return this.qte + "kg de " + this.ingr.nom;
    }

}