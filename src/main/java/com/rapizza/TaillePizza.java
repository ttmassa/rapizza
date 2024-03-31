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
}