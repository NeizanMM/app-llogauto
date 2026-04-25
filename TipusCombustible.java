package com.llogaauto;

/**
 * Enum TipusCombustible - A5.3
 * Defineix els tipus de combustible amb el preu per unitat
 */
public enum TipusCombustible {
    BENZINA_95(1.62),
    BENZINA_98(1.75),
    DIESEL(1.48),
    ELECTRIC(0.25),
    HIBRID(1.10);

    private final double preuPerUnitat;

    // Constructor de l'enum
    TipusCombustible(double preu) {
        this.preuPerUnitat = preu;
    }

    public double getPreu() {
        return preuPerUnitat;
    }
}
