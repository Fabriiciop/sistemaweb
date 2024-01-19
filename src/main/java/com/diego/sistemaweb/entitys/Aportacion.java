package com.diego.sistemaweb.entitys;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "aportaciones") // Name of the table in the database
public class Aportacion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "socio_id") // Name of the column that stores the Socio ID in the Aportaciones table
    private Socio socio;

    private Date fechaAportacion;
    private String tipoAportacion;
    private String movimiento;
    private Float cantidadAport;

    // Constructors, getters, and setters
    
    public Aportacion(Long id, Socio socio, Date fechaAportacion, String tipoAportacion, String movimiento, Float cantidadAport) {
        this.id = id;
        this.socio = socio;
        this.fechaAportacion = fechaAportacion;
        this.tipoAportacion = tipoAportacion;
        this.movimiento = movimiento;
        this.cantidadAport = cantidadAport;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Date getFechaAportacion() {
        return fechaAportacion;
    }

    public void setFechaAportacion(Date fechaAportacion) {
        this.fechaAportacion = fechaAportacion;
    }

    public String getTipoAportacion() {
        return tipoAportacion;
    }

    public void setTipoAportacion(String tipoAportacion) {
        this.tipoAportacion = tipoAportacion;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public Float getCantidadAport() {
        return cantidadAport;
    }

    public void setCantidadAport(Float cantidadAport) {
        this.cantidadAport = cantidadAport;
    }

    // Other methods
}
