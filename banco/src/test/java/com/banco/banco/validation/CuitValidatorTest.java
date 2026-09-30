package com.banco.banco.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * ¿Qué es un TEST?
 * Es un método que ejecuta tu código y comprueba si el resultado es el esperado.
 *
 * JUnit = la librería que corre estos métodos automáticamente.
 *
 * Estructura Given / When / Then (solo comentarios para ordenarte):
 * - Given = preparo el dato de entrada
 * - When  = llamo al método que quiero probar
 * - Then  = verifico el resultado (Assertion)
 *
 * Assertion = "afirmo que esto tiene que ser así".
 * Si falla, el test se pone en rojo.
 */
class CuitValidatorTest {

    private CuitValidator cuitValidator;

    // @BeforeEach = se ejecuta ANTES de cada @Test
    // Así cada test empieza con un validador nuevo y limpio
    @BeforeEach
    void setUp() {
        cuitValidator = new CuitValidator();
    }

    // @Test = "esto es un test, correlo"
    @Test
    void cuitConOnceDigitosEsValido() {
        // Given (preparo)
        String cuit = "20123456789";

        // When (ejecuto)
        boolean resultado = cuitValidator.esValido(cuit);

        // Then (verifico): afirmo que es true
        assertTrue(resultado);
    }

    @Test
    void cuitConGuionesTambienEsValido() {
        // Given
        String cuit = "20-12345678-9";

        // When
        boolean resultado = cuitValidator.esValido(cuit);

        // Then
        assertTrue(resultado);
    }

    @Test
    void cuitCortoNoEsValido() {
        // Given
        String cuit = "20-123";

        // When
        boolean resultado = cuitValidator.esValido(cuit);

        // Then: afirmo que es false
        assertFalse(resultado);
    }
}
