package com.rapizza;

import java.util.*;

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
    public Vector<LigneRecette> listIngr;


    /**
     * Default constructor
     */
    public Ingredient(String nom, double prixKg) {
        this.nom = nom;
        this.prixKg = prixKg;
        this.listIngr = new Vector<LigneRecette>();
    }

    public void ajouterLigneRecette(Pizza pizza, double qte) {
        LigneRecette ligne = new LigneRecette(qte, pizza, this);
        this.listIngr.add(ligne);
    }

    public void retirerLigneRecette(LigneRecette ligne) {
        this.listIngr.remove(ligne);
    }

    public void modifierPrix(double prix) {
        this.prixKg = prix;
    }

    public void modifierNom(String nom) {
        this.nom = nom;
    }

    public void afficherRecette() {
        for (LigneRecette ligne : this.listIngr) {
            System.out.println(ligne.toString());
        }
    }

}