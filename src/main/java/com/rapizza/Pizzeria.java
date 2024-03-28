package com.rapizza;

import java.util.*;

/**
 * 
 */
public class Pizzeria {
    /**
     * Attributes
     */
    public String adresse;
    /**
     * Associations
     */
    public Vector<Client> listClient;
    public Vector<Pizza> menu;
    public Vector<Commande> listCo;
    public Vector<Livreur> listLivreur;


    /**
     * Default constructor
     */
    public Pizzeria(String adresse) {
        this.adresse = adresse;
        this.listClient = new Vector<Client>();
        this.menu = new Vector<Pizza>();
        this.listCo = new Vector<Commande>();
        this.listLivreur = new Vector<Livreur>();
    }

    public void fabriquerCommande(Commande commande) {
        if (isClient(commande.client)) {
            this.listCo.add(commande);
        }
    }

    public void affecterLivreur(Commande commande) {
        int random = (int) (Math.random() * this.listLivreur.size());

        while (!this.listLivreur.get(random).isAvailable) {
            random = (int) (Math.random() * this.listLivreur.size());
        }

        this.listLivreur.get(random).affecterLivraison(commande);
    }

    public void fabriquerPizza(String nom, Vector<Ingredient> ingredients, double prixMarge) {
        Pizza pizza = new Pizza(nom, ingredients, prixMarge, null, this);
        this.menu.add(pizza);
    }

    public void ajouterPizza(Pizza pizza) {
        this.menu.add(pizza);
    }

    public void ajouterClient(Client client) {
        this.listClient.add(client);
    }

    public void ajouterCommande(Commande commande) {
        this.listCo.add(commande);
    }

    public void ajouterLivreur(Livreur livreur) {
        this.listLivreur.add(livreur);
    }

    public void retirerPizza(Pizza pizza) {
        this.menu.remove(pizza);
    }

    public void retirerClient(Client client) {
        this.listClient.remove(client);
    }

    public void retirerCommande(Commande commande) {
        this.listCo.remove(commande);
    }

    public void retirerLivreur(Livreur livreur) {
        this.listLivreur.remove(livreur);
    }

    public boolean isClient(Client client) {
        return this.listClient.contains(client);
    }

}