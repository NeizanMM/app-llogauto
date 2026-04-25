package com.llogaauto;

/**
 * Classe Cotxe - A5.3
 * Hereta d'Automobil (herència). Afegeix numPortes.
 */
public class Cotxe extends Automobil {

    private int numPortes;

    // Constructor amb paràmetres
    public Cotxe(String marca, String model, String matricula,
                 TipusCombustible combustible, int numPortes) {
        super(marca, model, matricula, combustible); // crida al constructor del pare
        this.numPortes = numPortes;
    }

    // Constructor sense paràmetres
    public Cotxe() {
        super();
    }

    // ── GETTER / SETTER ───────────────────────────────────

    public int getNumPortes()            { return numPortes; }
    public void setNumPortes(int numPortes) { this.numPortes = numPortes; }

    // ── SOBRECARREGA mostrarDades() ───────────────────────

    @Override
    public String mostrarDades() {
        return super.mostrarDades() + " | Portes: " + numPortes;
    }
}
