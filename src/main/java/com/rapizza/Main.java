package com.rapizza;

import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Pizzeria pizzeria = new Pizzeria("1 rue de la pizza");

        Client moi = new Client("06 67 37 87 72", pizzeria);

        Ingredient fromage = new Ingredient("fromage", 0.5);
        Ingredient tomate = new Ingredient("tomate", 1);
        Ingredient basilic = new Ingredient("basilic", 0.1);

        Pizza margherita = new Pizza("Margheritta", 5.0, new Vector<Ingredient>(List.of(fromage, tomate, basilic)));

        pizzeria.ajouterPizza(margherita);

        pizzeria.afficherMenu();

        moi.ajouterLigne("Margheritta", 2, "OGRESSE");

        Livreur livreur = new Livreur(pizzeria);

        pizzeria.listLivreur.add(livreur);

        moi.recharger(50.00);

        
        moi.profilInfo();

        moi.passerCommande();

        moi.profilInfo();

    }
}