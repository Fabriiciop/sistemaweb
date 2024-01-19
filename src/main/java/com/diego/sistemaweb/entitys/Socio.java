package com.diego.sistemaweb.entitys;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Socio implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nombre;
    private String apellido;
    private String descripcion;
    private float inversionTotal;
    private float creditoTotal;
    private float deuda;
    private float interesGenerado;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public float getInversionTotal() {
        return inversionTotal;
    }
    public void setInversionTotal(float inversionTotal) {
        this.inversionTotal = inversionTotal;
    }
    public float getCreditoTotal() {
        return creditoTotal;
    }
    public void setCreditoTotal(float creditoTotal) {
        this.creditoTotal = creditoTotal;
    }
    public float getDeuda() {
        return deuda;
    }
    public void setDeuda(float deuda) {
        this.deuda = deuda;
    }
    public float getInteresGenerado() {
        return interesGenerado;
    }
    public void setInteresGenerado(float interesGenerado) {
        this.interesGenerado = interesGenerado;
    }
    public Socio(Long id, String nombre, String apellido, String descripcion, float inversionTotal, float creditoTotal,
            float deuda, float interesGenerado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.inversionTotal = inversionTotal;
        this.creditoTotal = creditoTotal;
        this.deuda = deuda;
        this.interesGenerado = interesGenerado;
    }
    
   

}
