package com.banco.banco.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PREMIUM")
public class Premium extends Cliente {

    private float limiteCreditoEspecial;
    private String ejecutivoDeCuenta;
    private String beneficios;

    public Premium() {
    }

    public Premium(Long id, String nombre, String apellidoRazonSocial,
                   String direccion, String telefono, String correo, String fechaAlta,
                   float limiteCreditoEspecial, String ejecutivoDeCuenta, String beneficios) {
        super(id, nombre, apellidoRazonSocial, direccion, telefono, correo, fechaAlta);
        this.limiteCreditoEspecial = limiteCreditoEspecial;
        this.ejecutivoDeCuenta = ejecutivoDeCuenta;
        this.beneficios = beneficios;
    }

    public float getLimiteCreditoEspecial() {
        return limiteCreditoEspecial;
    }

    public String getEjecutivoDeCuenta() {
        return ejecutivoDeCuenta;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setLimiteCreditoEspecial(float limiteCreditoEspecial) {
        this.limiteCreditoEspecial = limiteCreditoEspecial;
    }

    public void setEjecutivoDeCuenta(String ejecutivoDeCuenta) {
        this.ejecutivoDeCuenta = ejecutivoDeCuenta;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public void aumentarLimiteCredito(float porcentaje) {
        this.limiteCreditoEspecial += this.limiteCreditoEspecial * (porcentaje / 100);
    }

    public boolean puedeRealizarCompra(float montoCompra) {
        return montoCompra <= this.limiteCreditoEspecial;
    }
}
