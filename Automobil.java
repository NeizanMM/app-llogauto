package com.llogaauto;

/**
 * Classe Automobil - Representa un vehicle de lloguer
 * LlogaAuto, S.L.
 */
public class Automobil {

    // Atributs
    public String marca;
    public String model;
    public String matricula;

    /**
     * Constructor de la classe Automobil
     * @param marca     Marca del vehicle (ex: Toyota, Ford...)
     * @param model     Model del vehicle (ex: Corolla, Focus...)
     * @param matricula Matrícula del vehicle (format: 1234ABC)
     */
    public Automobil(String marca, String model, String matricula) {
        this.marca = marca;
        this.model = model;
        this.matricula = matricula;
    }

    /**
     * Retorna les dades del vehicle en format text
     * @return String amb les dades del vehicle
     */
    public String mostrarDades() {
        return "Marca: " + marca + " | Model: " + model + " | Matrícula: " + matricula;
    }

    /**
     * Funció que retorna true si una matrícula és vàlida a Espanya
     * Format vàlid: 4 dígits numèrics + 3 lletres consonants (sense vocals ni Ñ)
     * Exemple: 1234LMN, 0000BBB
     *
     * @param matricula String amb la matrícula a validar
     * @return true si la matrícula és correcta, false en altre cas
     */
    public static boolean validarMatricula(String matricula) {
        // Ha de tenir exactament 7 caràcters
        if (matricula == null || matricula.length() != 7) {
            return false;
        }

        // Lletres no permeses: vocals (A, E, I, O, U) i Ñ, Q
        String lletresNoPermeses = "AEIOUÑQ";

        // Comprovar els 4 primers caràcters: han de ser dígits
        for (int i = 0; i < 4; i++) {
            if (!Character.isDigit(matricula.charAt(i))) {
                return false;
            }
        }

        // Comprovar els 3 últims caràcters: han de ser lletres consonants permeses
        for (int i = 4; i < 7; i++) {
            char c = Character.toUpperCase(matricula.charAt(i));
            if (!Character.isLetter(c)) {
                return false;
            }
            if (lletresNoPermeses.indexOf(c) != -1) {
                return false;
            }
        }

        return true;
    }

    // Programa principal per provar la classe
    public static void main(String[] args) {
        // Creació de 3 instàncies de la classe Automobil
        Automobil auto1 = new Automobil("Toyota", "Corolla", "1234LMN");
        Automobil auto2 = new Automobil("Ford", "Focus", "5678BCD");
        Automobil auto3 = new Automobil("Seat", "Ibiza", "9012FGH");

        // Mostrar les dades de cada vehicle
        System.out.println("=== Vehicles de LlogaAuto S.L. ===");
        System.out.println(auto1.mostrarDades());
        System.out.println(auto2.mostrarDades());
        System.out.println(auto3.mostrarDades());

        // Provar la validació de matrícules
        System.out.println("\n=== Validació de matrícules ===");
        System.out.println("1234LMN vàlida? " + validarMatricula("1234LMN")); // true
        System.out.println("0000BBB vàlida? " + validarMatricula("0000BBB")); // true
        System.out.println("1234ABC vàlida? " + validarMatricula("1234ABC")); // false (vocals)
        System.out.println("123BBB  vàlida? " + validarMatricula("123BBB"));  // false (falta número)
    }
}
