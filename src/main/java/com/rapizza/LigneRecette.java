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
    public LigneRecette(double qte, Pizza pizza, Ingredient ingr) {
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