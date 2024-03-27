package com.rapizza;

import java.util.*;

/**
 * 
 */
public class Pizza {

    /**
     * Default constructor
     */
    public Pizza() {
    }

    /**
     * 
     */
    public String nom;

    /**
     * 
     */
    public String[] ingredients;

    /**
     * 
     */
    public double prixBase;

    /**
     * 
     */
    public Client client;

    /**
     * 
     */
    public Pizzeria pizzeria;

    /**
     * 
     */
    public Set<LigneRecette> listLigneR;

    /**
     * 
     */
    public Set<LigneC> listLigne;

}