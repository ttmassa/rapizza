package com.rapizza;
/**
 * 
 */
public enum TaillePizza {
    NAINE, // -1/3 de HUMAINE
    HUMAINE,
    OGRESSE; // +1/3 de HUMAINE

    public double getRatio() {
        switch (this) {
            case NAINE:
                return 0.66;
            case HUMAINE:
                return 1;
            case OGRESSE:
                return 1.33;
            default:
                return 1;
        }
    }

    public String toString() {
        switch (this) {
            case NAINE:
                return "Naine";
            case HUMAINE:
                return "Humaine";
            case OGRESSE:
                return "Ogresse";
            default:
                return "Humaine";
        }
    }

    public static TaillePizza fromString(String taille) {
        switch (taille) {
            case "Naine":
                return NAINE;
            case "Humaine":
                return HUMAINE;
            case "Ogresse":
                return OGRESSE;
            default:
                return HUMAINE;
        }
    }
}