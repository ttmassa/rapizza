package com.rapizza;


/**
 * 
 */
public class LigneC {
    /**
     * Attributes
     */
    public int qte;
    public TaillePizza taille;
    /**
     * Associations
     */
    public Commande commande;
    public Pizza pizza;

    /**
     * Default constructor
     */
    public LigneC(int qte, TaillePizza taille, Commande commande, Pizza pizza) {
        this.qte = qte;
        this.taille = taille;
        this.commande = commande;
        this.pizza = pizza;
    }

}