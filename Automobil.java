package com.llogaauto;

/**
 * Classe abstracta Automobil - A5.3
 * No es pot instanciar directament: cal usar Cotxe o Camio
 */
public abstract class Automobil {

    // Atributs privats
    private String marca;
    private String model;
    private String matricula;
    private TipusCombustible combustible;
    private static int comptador = 0;

    // Constructor amb paràmetres
    public Automobil(String marca, String model, String matricula, TipusCombustible combustible) {
        this.marca = marca;
        this.model = model;
        this.matricula = matricula;
        this.combustible = combustible;
        comptador++;
    }

    // Constructor sense paràmetres
    public Automobil() {
        comptador++;
    }

    // ── GETTERS ──────────────────────────────────────────

    public String getMarca()               { return marca; }
    public String getModel()               { return model; }
    public String getMatricula()           { return matricula; }
    public TipusCombustible getCombustible() { return combustible; }
    public static int getComptador()       { return comptador; }

    // ── SETTERS ──────────────────────────────────────────

    public void setMarca(String marca)                     { this.marca = marca; }
    public void setModel(String model)                     { this.model = model; }
    public void setMatricula(String matricula)             { this.matricula = matricula; }
    public void setCombustible(TipusCombustible combustible) { this.combustible = combustible; }

    // ── MÈTODES ──────────────────────────────────────────

    /**
     * mostrarDades és sobrecarregat per Cotxe i Camio (polimorfisme)
     */
    public String mostrarDades() {
        String combu = (combustible != null)
            ? combustible.name() + " (" + combustible.getPreu() + "€/u)"
            : "no especificat";
        return "Marca: " + marca +
               " | Model: " + model +
               " | Matrícula: " + matricula +
               " | Combustible: " + combu;
    }

    public static boolean validarMatricula(String matricula) {
        if (matricula == null || matricula.length() != 7) return false;
        String noPermeses = "AEIOUÑQ";
        for (int i = 0; i < 4; i++) {
            if (!Character.isDigit(matricula.charAt(i))) return false;
        }
        for (int i = 4; i < 7; i++) {
            char c = Character.toUpperCase(matricula.charAt(i));
            if (!Character.isLetter(c) || noPermeses.indexOf(c) != -1) return false;
        }
        return true;
    }
}
