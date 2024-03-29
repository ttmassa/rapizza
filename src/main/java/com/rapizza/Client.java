package com.rapizza;

import java.util.*;

/**
 * 
 */
public class Client {
    /**
     * Attributes
     */
    public int numTelephone;
    public double solde;
    public int nbrCommande = 0;
    /**
     * Associations
     */
    public Pizzeria pizzeria;
    public Vector<LigneC> listPizza;
    public Vector<Commande> listCo;


    /**
     * Default constructor
     */
    public Client(int numTelephone, double solde, Pizzeria pizzeria) {
        this.numTelephone = numTelephone;
        this.solde = solde;
        this.pizzeria = pizzeria;
        this.listCo = new Vector<Commande>();
    }

    public void passerCommande() {
        Commande commande = new Commande(this, this.pizzeria, listPizza);
        ajouterCommande(commande);
        effacerLignes();
    }

    public void ajouterLigne(Pizza pizza, int qte, TaillePizza taille) {
        LigneC ligne = new LigneC(pizza, qte, taille);
        this.listPizza.add(ligne);
    }

    public void effacerLignes() {
        this.listPizza.clear();
    }

    public void recharger(double montant) {
        this.solde += montant;
    }

    public void retirer(double montant) {
        this.solde -= montant;
    }

    public void ajouterCommande(Commande commande) {
        this.listCo.add(commande);
    }

    public void annulerCommande(Commande commande) {
        this.listCo.remove(commande);
    }

}