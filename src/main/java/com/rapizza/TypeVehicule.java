package com.rapizza;
/**
 * 
 */
public enum TypeVehicule {
    voiture,
    moto;

    public String toString() {
        switch (this) {
            case voiture:
                return "Voiture";
            case moto:
                return "Moto";
            default:
                return "Voiture";
        }
    }
}