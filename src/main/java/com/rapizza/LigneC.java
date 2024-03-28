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

    public double getCoeff() {
        if (this.taille == TaillePizza.naine) {
            return 2/3;
        } else if (this.taille == TaillePizza.humaine) {
            return 1;
        } else {
            return 4/3;
        }
    }

    public double getPrix() {
        return this.qte * this.pizza.getPrix() * this.getCoeff();
    }

}