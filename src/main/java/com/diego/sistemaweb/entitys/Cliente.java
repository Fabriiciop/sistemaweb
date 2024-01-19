package com.diego.sistemaweb.entitys;

public class Cliente {
    // Atributos
    private Long id;
    private String role;
    private String usuario;
    private String password;
    

    // Constructor
    public Cliente(Long id, String role, String usuario, String password) {
        this.id = id;
        this.role = role;
        this.usuario = usuario;
        this.password = password;
    }

    // Getter y Setter (opcional)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsuario() {
        return usuario;
    }

    public void set(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setNombre(String password) {
        this.password = password;
    }

}
