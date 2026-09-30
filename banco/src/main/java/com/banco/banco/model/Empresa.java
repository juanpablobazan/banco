package com.banco.banco.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EMPRESA")
public class Empresa extends Cliente {

    private String razonSocial;
    private String cuit;
    private String rubroActividadEmpresa;
    private String representante;

    public Empresa() {
    }

    public Empresa(Long id, String nombre, String apellidoRazonSocial,
                   String direccion, String telefono, String correo, String fechaAlta,
                   String razonSocial, String cuit, String rubroActividadEmpresa, String representante) {
        super(id, nombre, apellidoRazonSocial, direccion, telefono, correo, fechaAlta);
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.rubroActividadEmpresa = rubroActividadEmpresa;
        this.representante = representante;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public String getRubroActividadEmpresa() {
        return rubroActividadEmpresa;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setRubroActividadEmpresa(String rubroActividadEmpresa) {
        this.rubroActividadEmpresa = rubroActividadEmpresa;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getCuitFormateado() {
        return "CUIT: " + this.cuit;
    }
}
