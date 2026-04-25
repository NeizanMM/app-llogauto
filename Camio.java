package com.llogaauto;

/**
 * Classe Camio - A5.3
 * Hereta d'Automobil. Afegeix tara i pesMaxim (Float).
 */
public class Camio extends Automobil {

    private Float tara;
    private Float pesMaxim;

    // Constructor amb paràmetres
    public Camio(String marca, String model, String matricula,
                 TipusCombustible combustible, Float tara, Float pesMaxim) {
        super(marca, model, matricula, combustible);
        this.tara = tara;
        this.pesMaxim = pesMaxim;
    }

    // Constructor sense paràmetres
    public Camio() {
        super();
    }

    // ── GETTERS / SETTERS ─────────────────────────────────

    public Float getTara()                 { return tara; }
    public void setTara(Float tara)        { this.tara = tara; }
    public Float getPesMaxim()             { return pesMaxim; }
    public void setPesMaxim(Float pesMaxim){ this.pesMaxim = pesMaxim; }

    // ── SOBRECARREGA mostrarDades() ───────────────────────

    @Override
    public String mostrarDades() {
        return super.mostrarDades() +
               " | Tara: " + tara + "t" +
               " | Pes màx: " + pesMaxim + "t";
    }
}
