package com.angel.juan.app_tuviaje.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity()
public class Reserva {

    @Id(autoincrement = true)
    Long id;
    String nombre;
    String fecha;
    String costo;


    @Generated(hash = 1256752394)
    public Reserva(Long id, String nombre, String fecha, String costo) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.costo = costo;
    }
    @Generated(hash = 961270578)
    public Reserva() {
    }

    public Long getId(){return id;}
    public void setId(Long id) {this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getFecha() {return fecha;}
    public void setFecha(String fecha) {this.fecha = fecha;}

    public String getCosto() {return costo;}
    public void setCosto(String costo) {this.costo = costo;}


}
