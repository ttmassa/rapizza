package com.rapizza;
/**
 * 
 */
public enum TaillePizza {
    naine, // -1/3 de humaine
    humaine,
    ogresse; // +1/3 de humaine

    public double getRatio() {
        switch (this) {
            case naine:
                return 0.66;
            case humaine:
                return 1;
            case ogresse:
                return 1.33;
            default:
                return 1;
        }
    }
}