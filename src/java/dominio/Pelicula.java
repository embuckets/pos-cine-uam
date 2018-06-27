/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.time.Duration;

/**
 *
 * @author emilio
 */
public class Pelicula {
    private String nombre;
    private Duration duracion;
    public static enum Clasificacion {AA, A, B, B15, C, D}
    private Clasificacion clasificacion;
    
    public Pelicula(String nombre, Duration duracion, Pelicula.Clasificacion clasificacion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
    }

    @Override
    public String toString() {
        return "[" + nombre + ", " + duracion.toMinutes() + ", " + clasificacion.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Pelicula) {
            Pelicula pelicula = (Pelicula) o;
            return nombre.equalsIgnoreCase(pelicula.getNombre());
        }
        else return false;
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Duration getDuracion() {
        return duracion;
    }

    public void setDuracion(Duration duracion) {
        this.duracion = duracion;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }
    
    
    
}
