package com.llogaauto;

/**
 * Classe GestorAutomobils - A5.2
 * Gestiona una llista d'automòbils amb un array de capacitat fixa
 */
public class GestorAutomobils {

    private Automobil[] llistaCotxes;

    // Constructor: defineix la capacitat màxima de la llista
    public GestorAutomobils(int capacitat) {
        llistaCotxes = new Automobil[capacitat];
    }

    /**
     * Afegeix un automòbil a la posició indicada
     * @param posicio índex de l'array (0-based)
     * @param auto    objecte Automobil a inserir
     */
    public void afegirAutomobil(int posicio, Automobil auto) {
        if (posicio >= 0 && posicio < llistaCotxes.length) {
            llistaCotxes[posicio] = auto;
            System.out.println("Automòbil afegit a la posició " + posicio + ".");
        } else {
            System.out.println("Posició invàlida. Ha de ser entre 0 i " + (llistaCotxes.length - 1));
        }
    }

    /**
     * Llista tots els automòbils registrats
     */
    public void llistarAutomobils() {
        System.out.println("\n══════════════════════════════════════");
        System.out.println("  Llista de vehicles - LlogaAuto S.L.");
        System.out.println("══════════════════════════════════════");
        boolean hiHaCap = false;
        for (int i = 0; i < llistaCotxes.length; i++) {
            if (llistaCotxes[i] != null) {
                System.out.println("[" + i + "] " + llistaCotxes[i].mostrarDades());
                hiHaCap = true;
            }
        }
        if (!hiHaCap) {
            System.out.println("  (cap vehicle registrat)");
        }
        System.out.println("══════════════════════════════════════\n");
    }
}
