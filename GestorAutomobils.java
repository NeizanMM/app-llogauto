package com.llogaauto;

/**
 * GestorAutomobils - A5.3
 * Ara gestiona Automobil (abstracta), accepta Cotxe i Camio
 */
public class GestorAutomobils {

    private Automobil[] llistaCotxes;
    private int numAutos = 0;

    public GestorAutomobils(int capacitat) {
        llistaCotxes = new Automobil[capacitat];
    }

    public void afegirAutomobil(int posicio, Automobil auto) {
        if (posicio >= 0 && posicio < llistaCotxes.length) {
            llistaCotxes[posicio] = auto;
            numAutos++;
            System.out.println("Vehicle afegit a la posició " + posicio + ".");
        } else {
            System.out.println("Posició invàlida (0-" + (llistaCotxes.length - 1) + ").");
        }
    }

    public void llistarAutomobils() {
        System.out.println("\n══════════════════════════════════════════════");
        System.out.println("  Llista de vehicles - LlogaAuto S.L.");
        System.out.println("══════════════════════════════════════════════");
        boolean hiHaCap = false;
        for (int i = 0; i < llistaCotxes.length; i++) {
            if (llistaCotxes[i] != null) {
                String tipus = (llistaCotxes[i] instanceof Cotxe) ? "[COTXE]" : "[CAMIÓ]";
                System.out.println(tipus + " [" + i + "] " + llistaCotxes[i].mostrarDades());
                hiHaCap = true;
            }
        }
        if (!hiHaCap) System.out.println("  (cap vehicle registrat)");
        System.out.println("══════════════════════════════════════════════\n");
    }

    public int getNumAutos() { return numAutos; }
}
