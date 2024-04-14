package com.rapizza;

import java.util.Vector;

/**
 * 
 */
public class Pizza {
    /**
     * Attributes
     */
    public String nom;
    public Vector<Ingredient> ingredients;
    public double prixMarge;
    
    /**
     * Associations
     */
    public Client client;
    public Pizzeria pizzeria;
    public Vector<LigneRecette> listLigneR;
    public Vector<LigneC> listLigne;
    // For the GUI
    static public Vector<Pizza> listPizzas = new Vector<Pizza>();


    /**
     * Default constructor
     * J'aime pas la manière dont on crée une pizza mais j'ai pas d'autre idée
     * En gros, on crée la pizza avec un nom, son prix de marge et les ingrédients. Ensuite, le constructeur crée les lignes de recette
     * en initialisant la quantité à 1 pour chaque ingrédient. Pour changer la quantité, il faut utiliser la méthode changeQuantity ce qui
     * n'est pas très pratique.
     * Une autre solution ça serait de créer la pizza avec un nom, son prix de marge et les lignes de recette. Mais ça oblige à créer les
     * lignes de recette avant de créer la pizza. Ce qui n'est pas très pratique non plus.
     */
    public Pizza(String nom, Vector <Ingredient> ingredients, double prixMarge, Client client, Pizzeria pizzeria) {
        this.nom = nom;
        this.prixMarge = prixMarge;
        this.client = client;
        this.pizzeria = pizzeria;
        this.ingredients = new Vector<Ingredient>();
        this.listLigneR = new Vector<LigneRecette>();
        this.listLigne = new Vector<LigneC>();
    }

    public Pizza(String nom, double prixMarge, Vector <Ingredient> ingredients) {
        this.nom = nom;
        this.prixMarge = prixMarge;
        this.ingredients = ingredients;
        this.listLigneR = new Vector<LigneRecette>();
        for (Ingredient ingr : ingredients) {
            this.listLigneR.add(new LigneRecette(this, ingr, 1));
        }
        this.listLigne = new Vector<LigneC>();
    }

    /*
     * Methods
     */
    
    public double getPrix() {
        double prix = this.prixMarge;

        for (LigneRecette ligne : this.listLigneR) {
            prix += ligne.getPrix();
        }

        return prix;
    }

    public double getPrix(TaillePizza taille) {
        double prix = this.prixMarge;

        for (LigneRecette ligne : this.listLigneR) {
            prix += ligne.getPrix() * taille.getRatio();
        }

        return Math.round(prix * 100.0) / 100.0;
    }

    public void changeQuantity(Ingredient ingr, double qte) {
        for (LigneRecette ligne : this.listLigneR) {
            if (ligne.ingr == ingr) {
                ligne.qte = qte;
                return;
            }
        }
    }

    public void addIngredient(Ingredient ingr) {
        this.ingredients.add(ingr);
        this.listLigneR.add(new LigneRecette(this, ingr, 1));
    }

    public Pizza getPizza(String nom) {
        for (Pizza pizza : listPizzas) {
            if (pizza.nom.equals(nom)) {
                return pizza;
            }
        }
        return null;
    }

}