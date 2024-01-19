package com.diego.sistemaweb.entitys;

public class empleado {
    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private int edad;
    private String tiposempleado;

    public empleado(Long id,String cedula, String nombre, String apellido, int edad, String tiposempleado) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.tiposempleado = tiposempleado;
    }

    
    // Getters y Setters (pueden ser generados automáticamente por el IDE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipoEmpleado() {
        return tiposempleado;
    }

    public void setTiposempleado(String tiposempleado) {
        this.tiposempleado = tiposempleado;
    }
}
