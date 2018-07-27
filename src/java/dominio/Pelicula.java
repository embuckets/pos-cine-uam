/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.time.Duration;
import java.util.Objects;

/**
 *
 * @author emilio
 */
public class Pelicula implements Comparable<Pelicula> {

    private final String nombre;
    private final Duration duracion;

    public static enum Clasificacion {
        AA, A, B, B15, C, D
    }
    private final Clasificacion clasificacion;

    public Pelicula(String nombre, Duration duracion, Pelicula.Clasificacion clasificacion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
    }

    @Override
    public int compareTo(Pelicula t) {
        return nombre.compareToIgnoreCase(t.getNombre());
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    /**
     * Son iguales solamente si tienen el mismo nombre. Los demas parametros no
     * se toman en cuenta
     *
     * @param obj
     * @return true si tienen el mismo nombre
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelicula other = (Pelicula) obj;
        if (!this.nombre.equalsIgnoreCase(other.nombre)) {
            return false;
        }
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public Duration getDuracion() {
        return duracion;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

}
