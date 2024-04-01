package com.rapizza;

import java.util.Vector;

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
        // Check if the client is registered and if the order is allowed
        if (isClient(commande.client) && isCommandeFaisable(commande)) {
            choisirLivreur(commande);
            this.listCo.add(commande);
        } else {
            System.out.println("Client non enregistré");
            return;
        }
    }

    public void choisirLivreur(Commande commande) {
        if (this.listLivreur.isEmpty()) {
            System.out.println("Pas de livreur disponible");
            return;
        }
        int random = (int) (Math.random() * this.listLivreur.size());

        while (!this.listLivreur.get(random).isAvailable) {
            random = (int) (Math.random() * this.listLivreur.size());
        }

        this.listLivreur.get(random).affecterLivraison(commande);;
    }

    public boolean isPizzaAlvailable(Pizza pizza) {
        // Check if the menu contains the pizza asked
        return this.menu.contains(pizza);
    }

    public boolean isCommandeFaisable(Commande commande) {
        for (LigneC ligne : commande.listLigne) {
            if (!isPizzaAlvailable(ligne.pizza)) {
                return false;
            }
        }
        return true;
    }

    public void afficherMenu() {
        for (Pizza pizza : this.menu) {
            System.out.println(
                pizza.nom + " : Naine = " + pizza.getPrix(TaillePizza.NAINE) + 
                " euros, Humaine = " + pizza.getPrix(TaillePizza.HUMAINE) + 
                " euros, Ogresse = " + pizza.getPrix(TaillePizza.OGRESSE) + " euros"
            );
        }
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

    public void recruterLivreur(Livreur livreur) {
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

    public void virerLivreur(Livreur livreur) {
        this.listLivreur.remove(livreur);
    }

    public boolean isClient(Client client) {
        return this.listClient.contains(client);
    }

}