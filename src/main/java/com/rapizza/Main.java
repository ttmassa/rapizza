package com.rapizza;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Pizzeria pizzeria = new Pizzeria("1 rue de la pizza");

        Client moi = new Client("06 67 37 87 72", pizzeria);

        Ingredient fromage = new Ingredient("fromage", 0.5);
        Ingredient tomate = new Ingredient("tomate", 1);
        Ingredient basilic = new Ingredient("basilic", 0.1);

        Vector<Ingredient> margheritaIngredients = new Vector<Ingredient>();
        margheritaIngredients.add(fromage);
        margheritaIngredients.add(tomate);
        margheritaIngredients.add(basilic);

        Pizza margherita = new Pizza("Margheritta", 5.0, margheritaIngredients);

        pizzeria.ajouterPizza(margherita);

        pizzeria.afficherMenu();

        moi.ajouterLigne("Margheritta", 2, TaillePizza.ogresse);

        Livreur livreur = new Livreur(pizzeria);

        pizzeria.listLivreur.add(livreur);

        moi.recharger(50);

        moi.passerCommande();

    }
}