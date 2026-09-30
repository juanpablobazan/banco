package com.banco.banco.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

/**
 * Clase base de clientes.
 * SINGLE_TABLE = todos los tipos (Empresa, PersonaFisica, Premium)
 * se guardan en UNA sola tabla "clientes", con una columna "tipo"
 * que indica de qué subclase es cada fila.
 */
@Entity
@Table(name = "clientes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidoRazonSocial;
    private String direccion;
    private String telefono;
    private String correo;
    private String fechaAlta;

    public Cliente() {
    }

    public Cliente(Long id, String nombre, String apellidoRazonSocial,
                   String direccion, String telefono, String correo, String fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoRazonSocial = apellidoRazonSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaAlta = fechaAlta;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoRazonSocial() {
        return apellidoRazonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoRazonSocial(String apellidoRazonSocial) {
        this.apellidoRazonSocial = apellidoRazonSocial;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String informacionDeCliente() {
        return ("Información de cliente id " + this.getId() + ": nombre: " + this.getNombre() +
                ", Apellido: " + this.getApellidoRazonSocial() + ", Correo: " + this.getCorreo() +
                ", Fecha de alta: " + this.getFechaAlta());
    }

    public boolean tieneCorreoValido() {
        return this.correo != null && this.correo.contains("@");
    }

    public boolean validarDatosCompletos() {
        return this.nombre != null && !this.nombre.isEmpty() &&
                this.telefono != null && !this.telefono.isEmpty();
    }
}
