package com.rapizza;

import java.util.Vector;

/**
 * 
 */
public class Client {
    /**
     * Attributes
     */
    public String numTelephone;
    public double solde;
    public int nbrCommande;
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
        this.nbrCommande = 0;
        this.listPizza = new Vector<LigneC>();
    }

    /*
     * Methods
     * To order a pizza -> - add Line(s) to the listPizza with ajouterLigne()
     *                     - pass the order with passCommande()
     */

    public void passerCommande() {
        if (this.listPizza.isEmpty()) {
            System.out.println("Commande vide");
            return;
        } else {
            Commande commande = new Commande(this, this.pizzeria, listPizza);
            ajouterCommande(commande);
            effacerLignes();    
        }
    }

    public void ajouterLigne(String nomPizza, int qte, String taille) {
        if (this.pizzeria.menu.stream().noneMatch(p -> p.nom.equals(nomPizza))) {
            System.out.println("Pizza non disponible");
        } else {
            // Get the pizza from the menu with the name given
            Pizza pizza = this.pizzeria.menu.stream().filter(p -> p.nom.equals(nomPizza)).findFirst().orElse(null);

            LigneC ligne = new LigneC(pizza, qte, TaillePizza.fromString(taille));
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
        this.nbrCommande = this.listCo.size();
    }

    public void annulerCommande(Commande commande) {
        this.listCo.remove(commande);
    }

    public void profilInfo() {
        System.out.println("Numéro de téléphone : " + this.numTelephone);
        System.out.println("Solde : " + this.solde);
        System.out.println("Nombre de commandes : " + this.nbrCommande);
    }

}