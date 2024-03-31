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
    public LigneC(Commande commande, Pizza pizza, int qte, TaillePizza taille) {
        this.qte = qte;
        this.taille = taille;
        this.commande = commande;
        this.pizza = pizza;
    }

    public LigneC(Pizza pizza, int qte, TaillePizza taille) {
        this.qte = qte;
        this.taille = taille;
        this.pizza = pizza;
    }

    public double getPrix() {
        return this.pizza.getPrix() * this.qte * this.taille.getRatio();
    }

}