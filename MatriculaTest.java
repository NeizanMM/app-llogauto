package com.llogaauto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Proves automatitzades JUnit per al mètode validarMatricula
 * de la classe Automobil
 */
class MatriculaTest {

    @Test
    void testMatriculaValida() {
        assertTrue(Automobil.validarMatricula("1234LMN")); // Format correcte
        assertTrue(Automobil.validarMatricula("0000BBB")); // Zeros i lletres vàlides
        assertTrue(Automobil.validarMatricula("9999ZZZ")); // Tots els 9 i Z
        assertTrue(Automobil.validarMatricula("1111BCD")); // Consonants vàlides
    }

    @Test
    void testMatriculaInvalida() {
        assertFalse(Automobil.validarMatricula("1234ABC")); // Té vocal (A)
        assertFalse(Automobil.validarMatricula("123ABC4")); // Ordre incorrecte
        assertFalse(Automobil.validarMatricula("123BBB"));  // Falta un número (6 chars)
        assertFalse(Automobil.validarMatricula("1234BÑB")); // Lletra no permesa (Ñ)
        assertFalse(Automobil.validarMatricula("ABCDLMN")); // Cap dígit als 4 primers
        assertFalse(Automobil.validarMatricula(null));      // Null
        assertFalse(Automobil.validarMatricula(""));        // Cadena buida
        assertFalse(Automobil.validarMatricula("1234EFG")); // Vocal E
    }
}
