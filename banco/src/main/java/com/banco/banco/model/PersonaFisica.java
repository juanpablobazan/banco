package com.banco.banco.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PERSONA_FISICA")
public class PersonaFisica extends Cliente {

    private String dni;
    private String fechaNacimiento;
    private String profesion;
    private float ingresosDeclarados;

    public PersonaFisica() {
    }

    public PersonaFisica(Long id, String nombre, String apellidoRazonSocial,
                         String direccion, String telefono, String correo, String fechaAlta,
                         String dni, String fechaNacimiento, String profesion, float ingresosDeclarados) {
        super(id, nombre, apellidoRazonSocial, direccion, telefono, correo, fechaAlta);
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.profesion = profesion;
        this.ingresosDeclarados = ingresosDeclarados;
    }

    public String getDni() {
        return dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getProfesion() {
        return profesion;
    }

    public float getIngresosDeclarados() {
        return ingresosDeclarados;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public void setIngresosDeclarados(float ingresosDeclarados) {
        this.ingresosDeclarados = ingresosDeclarados;
    }

    public float calcularCreditoMaximo() {
        return this.ingresosDeclarados * 0.30f;
    }
}
