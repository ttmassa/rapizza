package com.rapizza;

import java.util.Vector;

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
    // For the GUI
    public static Vector<LigneC> currentLigneC = new Vector<LigneC>();

    /**
     * Default constructor
     */
    public LigneC(Commande commande, Pizza pizza, int qte, TaillePizza taille) {
        this.qte = qte;
        this.taille = taille;
        this.commande = commande;
        this.pizza = pizza;
        currentLigneC.add(this);
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