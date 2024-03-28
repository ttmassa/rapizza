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
    /**
     * Associations
     */
    public Vector<Pizza> listPizza;
    public Pizzeria pizzeria;
    public Vector<Commande> listCo;


    /**
     * Default constructor
     */
    public Client(String numTelephone, double solde, Pizzeria pizzeria) {
        this.numTelephone = numTelephone;
        this.solde = solde;
        this.listPizza = new Vector<Pizza>();
        this.pizzeria = pizzeria;
        this.listCo = new Vector<Commande>();
    }

}