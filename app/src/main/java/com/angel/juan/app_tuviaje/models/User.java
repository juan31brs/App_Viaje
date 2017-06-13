package com.angel.juan.app_tuviaje.models;


public class User {

    Long idusuario;
    String nombre, usuario, password;

    public User(String nombre, String usuario, String password) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
    }

    public User(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public Long getIdusuario() {return idusuario;}

    public void setIdusuario(Long idusuario) {this.idusuario = idusuario;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getUsuario() {return usuario;}

    public void setUsuario(String usuario) {this.usuario = usuario;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}
}
