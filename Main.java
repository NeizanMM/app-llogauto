package com.llogaauto;

import java.util.Scanner;

/**
 * Programa principal - A5.2
 * Menú interactiu per gestionar automòbils
 */
public class Main {

    public static void main(String[] args) {

        // ── Punt 3: Crear les 3 instàncies amb constructor buit + setters ──
        Automobil auto1 = new Automobil();
        auto1.setMarca("Porche");
        auto1.setModel("Cayene");
        auto1.setMatricula("2323ABC");

        Automobil auto2 = new Automobil();
        auto2.setMarca("Mercedes");
        auto2.setModel("CLA");
        auto2.setMatricula("1234ABC");

        Automobil auto3 = new Automobil();
        auto3.setMarca("VW");
        auto3.setModel("Golf");
        auto3.setMatricula("2222ABC");

        // Imprimir valors de les instàncies
        System.out.println("── Instàncies creades ──");
        System.out.println(auto1.mostrarDades());
        System.out.println(auto2.mostrarDades());
        System.out.println(auto3.mostrarDades());
        System.out.println("Total vehicles creats (comptador): " + Automobil.getComptador());

        // ── Punt 4 i 5: GestorAutomobils amb menú ──
        GestorAutomobils gestor = new GestorAutomobils(10);
        Scanner sc = new Scanner(System.in);
        int opcio;

        do {
            System.out.println("\n╔══════════════════════════╗");
            System.out.println("║   LlogaAuto S.L. - Menú  ║");
            System.out.println("╠══════════════════════════╣");
            System.out.println("║  1 - Introduir dades     ║");
            System.out.println("║  2 - Llistar automòbils  ║");
            System.out.println("║  3 - Sortir              ║");
            System.out.println("╚══════════════════════════╝");
            System.out.print("Opció: ");
            opcio = sc.nextInt();
            sc.nextLine(); // netejar buffer

            switch (opcio) {
                case 1:
                    System.out.print("Posició a la llista (0-9): ");
                    int pos = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();

                    System.out.print("Model: ");
                    String model = sc.nextLine();

                    String matricula;
                    do {
                        System.out.print("Matrícula (format 1234XYZ): ");
                        matricula = sc.nextLine().toUpperCase();
                        if (!Automobil.validarMatricula(matricula)) {
                            System.out.println("  ✗ Matrícula invàlida. Torna-ho a intentar.");
                        }
                    } while (!Automobil.validarMatricula(matricula));

                    Automobil nouAuto = new Automobil(marca, model, matricula);
                    gestor.afegirAutomobil(pos, nouAuto);
                    break;

                case 2:
                    gestor.llistarAutomobils();
                    break;

                case 3:
                    System.out.println("Fins aviat!");
                    break;

                default:
                    System.out.println("Opció no vàlida.");
            }

        } while (opcio != 3);

        sc.close();
    }
}
