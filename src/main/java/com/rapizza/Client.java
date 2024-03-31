package com.rapizza;

import java.util.*;

/**
 * 
 */
public class Client {
    /**
     * Attributes
     */
    public String numTelephone;
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
    public Client(String numTelephone, Pizzeria pizzeria) {
        this.numTelephone = numTelephone;
        this.solde = 0;
        this.pizzeria = pizzeria;
        this.listCo = new Vector<Commande>();
        this.listPizza = new Vector<LigneC>();
        this.pizzeria.ajouterClient(this);
    }

    /*
     * Methods
     * To order a pizza -> - add Line(s) to the listPizza with ajouterLigne()
     *                     - pass the order with passCommande()
     */

    public void passerCommande() {
        Commande commande = new Commande(this, this.pizzeria, listPizza);
        ajouterCommande(commande);
        effacerLignes();
    }

    public void ajouterLigne(String nomPizza, int qte, TaillePizza taille) {
        if (this.pizzeria.menu.stream().noneMatch(p -> p.nom.equals(nomPizza))) {
            System.out.println("Pizza non disponible");
            return;
        } else {
            // Get the pizza from the menu with the name given
            Pizza pizza = this.pizzeria.menu.stream().filter(p -> p.nom.equals(nomPizza)).findFirst().orElse(null);

            LigneC ligne = new LigneC(pizza, qte, taille);
            this.listPizza.add(ligne);
        }
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