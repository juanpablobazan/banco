package com.banco.banco.exception;

/**
 * Excepción de negocio: algo falló por regla del dominio
 * (ej: CUIT inválido), no por un error técnico de red/base.
 */
public class NegocioException extends RuntimeException {

    public NegocioException(String mensaje) {
        super(mensaje);
    }
}
