/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fer
 */
public class Usuario {
    
    private String id_usuario;
    private String nombre;
    private String primerAp;
    private String segungoAp;

    public Usuario(String id_usuario, String nombre, String primerAp, String segungoAp) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.primerAp = primerAp;
        this.segungoAp = segungoAp;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerAp() {
        return primerAp;
    }

    public void setPrimerAp(String primerAp) {
        this.primerAp = primerAp;
    }

    public String getSegungoAp() {
        return segungoAp;
    }

    public void setSegungoAp(String segungoAp) {
        this.segungoAp = segungoAp;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", primerAp=" + primerAp + ", segungoAp=" + segungoAp + '}';
    }
    
    
    
}
