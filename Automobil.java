package com.llogaauto;

/**
 * Classe Automobil - A5.2 Diagrames de classes
 * Atributs privats + getters/setters + comptador static
 */
public class Automobil {

    // Atributs privats
    private String marca;
    private String model;
    private String matricula;
    private static int comptador = 0; // static: compartit per totes les instàncies

    // Constructor amb paràmetres
    public Automobil(String marca, String model, String matricula) {
        this.marca = marca;
        this.model = model;
        this.matricula = matricula;
        comptador++;
    }

    // Constructor sense paràmetres (requerit per l'activitat)
    public Automobil() {
        comptador++;
    }

    // ── GETTERS ──────────────────────────────────────────

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public String getMatricula() {
        return matricula;
    }

    public static int getComptador() {
        return comptador;
    }

    // ── SETTERS ──────────────────────────────────────────

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // ── MÈTODES ──────────────────────────────────────────

    public String mostrarDades() {
        return "Marca: " + marca + " | Model: " + model + " | Matrícula: " + matricula;
    }

    /**
     * Valida que la matrícula espanyola tingui format: 4 dígits + 3 consonants
     * Lletres no permeses: vocals (A,E,I,O,U), Ñ, Q
     */
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
