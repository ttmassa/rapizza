package com.rapizza;


/**
 * 
 */
public class LigneRecette {
    /**
     * Attributes
     */
    public int qte;
    /**
     * Associations
     */
    public Pizza pizza;
    public Ingredient ingr;

    /**
     * Default constructor
     */
    public LigneRecette(int qte, Pizza pizza, Ingredient ingr) {
        this.qte = qte;
        this.pizza = pizza;
        this.ingr = ingr;
    }

}