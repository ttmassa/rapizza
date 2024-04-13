package com.rapizza;

import java.util.Vector;

/**
 * 
 */
public class Ingredient {
    /**
     * Attributes
     */
    public String nom;
    public double prixKg;
    /**
     * Associations
     */
    public Vector<LigneRecette> listLigneR;
    // For the GUI 
    static public Vector<Ingredient> listIngr = new Vector<Ingredient>();

    /**
     * Default constructor
     */
    public Ingredient(String nom, double prixKg) {
        this.nom = nom;
        this.prixKg = prixKg;
        this.listLigneR = new Vector<LigneRecette>();
        listIngr.add(this);
    }

    public void ajouterLigneRecette(Pizza pizza, double qte) {
        LigneRecette ligne = new LigneRecette(pizza, this, qte);
        this.listLigneR.add(ligne);
    }

    public void retirerLigneRecette(LigneRecette ligne) {
        this.listLigneR.remove(ligne);
    }

    public void modifierPrix(double prix) {
        this.prixKg = prix;
    }

    public void modifierNom(String nom) {
        this.nom = nom;
    }

    public void afficherRecette() {
        for (LigneRecette ligne : this.listLigneR) {
            System.out.println(ligne.toString());
        }
    }

    public Vector<Ingredient> getlistIngr() {
        return listIngr;
    }

    public void setlistIngr(Vector<Ingredient> listIngr) {
        Ingredient.listIngr = listIngr;
    }

}