package com.llogaauto;

import java.util.Scanner;

/**
 * Main - A5.3
 * Prova cotxe1 (constructor normal), cotxe2 (constructor buit),
 * camió, i menú interactiu del gestor
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("══════════════════════════════════════════════");
        System.out.println("  Punt 3d - Proves de la classe Cotxe");
        System.out.println("══════════════════════════════════════════════");

        // i. cotxe1 amb constructor normal
        Cotxe cotxe1 = new Cotxe("Toyota", "Corolla", "1234LMN",
                                  TipusCombustible.BENZINA_95, 4);
        System.out.println("cotxe1: " + cotxe1.mostrarDades());

        // ii. cotxe2 amb constructor per defecte + setters
        Cotxe cotxe2 = new Cotxe();
        cotxe2.setMarca("Honda");
        cotxe2.setModel("Civic");
        cotxe2.setMatricula("5678BCD");
        cotxe2.setCombustible(TipusCombustible.HIBRID);
        cotxe2.setNumPortes(5);
        System.out.println("cotxe2: " + cotxe2.mostrarDades());

        // Punt 5 - Camió
        System.out.println("\n══════════════════════════════════════════════");
        System.out.println("  Punt 5 - Prova de la classe Camio");
        System.out.println("══════════════════════════════════════════════");

        Camio camio1 = new Camio("Volvo", "FH16", "9999BCD",
                                  TipusCombustible.DIESEL, 8.5f, 26.0f);
        System.out.println("camio1: " + camio1.mostrarDades());

        Camio camio2 = new Camio();
        camio2.setMarca("MAN");
        camio2.setModel("TGX");
        camio2.setMatricula("1111FGH");
        camio2.setCombustible(TipusCombustible.DIESEL);
        camio2.setTara(7.2f);
        camio2.setPesMaxim(20.0f);
        System.out.println("camio2: " + camio2.mostrarDades());

        System.out.println("\nTotal vehicles creats (comptador): " + Automobil.getComptador());

        // Menú interactiu
        GestorAutomobils gestor = new GestorAutomobils(10);
        Scanner sc = new Scanner(System.in);
        int opcio;

        do {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║    LlogaAuto S.L. - Menú       ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║  1 - Afegir cotxe              ║");
            System.out.println("║  2 - Afegir camió              ║");
            System.out.println("║  3 - Llistar vehicles          ║");
            System.out.println("║  4 - Sortir                    ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Opció: ");
            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {
                case 1: {
                    System.out.print("Posició (0-9): ");
                    int pos = sc.nextInt(); sc.nextLine();
                    System.out.print("Marca: ");     String marca = sc.nextLine();
                    System.out.print("Model: ");     String model = sc.nextLine();
                    String mat;
                    do {
                        System.out.print("Matrícula (1234XYZ): ");
                        mat = sc.nextLine().toUpperCase();
                        if (!Automobil.validarMatricula(mat))
                            System.out.println("  ✗ Matrícula invàlida.");
                    } while (!Automobil.validarMatricula(mat));
                    System.out.println("Combustible (BENZINA_95/BENZINA_98/DIESEL/ELECTRIC/HIBRID): ");
                    TipusCombustible combu = TipusCombustible.valueOf(sc.nextLine().toUpperCase());
                    System.out.print("Num portes: ");
                    int portes = sc.nextInt(); sc.nextLine();
                    gestor.afegirAutomobil(pos, new Cotxe(marca, model, mat, combu, portes));
                    break;
                }
                case 2: {
                    System.out.print("Posició (0-9): ");
                    int pos = sc.nextInt(); sc.nextLine();
                    System.out.print("Marca: ");     String marca = sc.nextLine();
                    System.out.print("Model: ");     String model = sc.nextLine();
                    String mat;
                    do {
                        System.out.print("Matrícula (1234XYZ): ");
                        mat = sc.nextLine().toUpperCase();
                        if (!Automobil.validarMatricula(mat))
                            System.out.println("  ✗ Matrícula invàlida.");
                    } while (!Automobil.validarMatricula(mat));
                    System.out.println("Combustible (BENZINA_95/BENZINA_98/DIESEL/ELECTRIC/HIBRID): ");
                    TipusCombustible combu = TipusCombustible.valueOf(sc.nextLine().toUpperCase());
                    System.out.print("Tara (t): ");  float tara = sc.nextFloat();
                    System.out.print("Pes màx (t): "); float pes = sc.nextFloat(); sc.nextLine();
                    gestor.afegirAutomobil(pos, new Camio(marca, model, mat, combu, tara, pes));
                    break;
                }
                case 3:
                    gestor.llistarAutomobils();
                    break;
                case 4:
                    System.out.println("Fins aviat!");
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }
        } while (opcio != 4);

        sc.close();
    }
}
