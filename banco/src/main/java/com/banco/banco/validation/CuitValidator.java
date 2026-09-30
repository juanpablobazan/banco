package com.banco.banco.validation;

import org.springframework.stereotype.Component;

/**
 * Versión INICIAL de validación de CUIT.
 *
 * Regla simple (para aprender):
 * - Si viene vacío -> NO vale
 * - Sacamos los guiones
 * - Tiene que quedar exactamente 11 números
 *
 * Más adelante se puede agregar el dígito verificador de AFIP.
 */
@Component
public class CuitValidator {

    /**
     * Devuelve true si el CUIT es válido, false si no.
     * Ejemplo válido: "20-12345678-9" o "20123456789"
     */
    public boolean esValido(String cuit) {
        // 1) Si no mandaron nada, no es válido
        if (cuit == null || cuit.isBlank()) {
            return false;
        }

        // 2) Sacamos guiones (y espacios) para comparar solo números
        String soloDigitos = cuit.replace("-", "").replace(" ", "");

        // 3) ¿Quedaron exactamente 11 dígitos?
        return soloDigitos.matches("\\d{11}");
    }

    /**
     * Si el CUIT NO es válido, corta el flujo lanzando un error.
     * Así el Service no guarda datos malos.
     */
    public void validarOFallar(String cuit) {
        if (!esValido(cuit)) {
            throw new com.banco.banco.exception.NegocioException(
                    "CUIT inválido. Debe tener 11 dígitos. Valor: " + cuit
            );
        }
    }
}
