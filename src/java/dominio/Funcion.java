/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.time.LocalDateTime;

/**
 *
 * @author emilio
 */
public class Funcion {

    private LocalDateTime fecha;

    public static enum Formato {
        DOS_D, TRES_D
    }

    public static enum Idioma {
        DOB, SUB
    }
    private Formato formato;
    private Idioma idioma;
    private Pelicula pelicula;
    private Sala sala;

    public Funcion(LocalDateTime fecha, Pelicula pelicula, Sala sala) {
        this.fecha = fecha;
        this.pelicula = pelicula;
        this.sala = sala;
        this.formato = Formato.DOS_D;
        this.idioma = Idioma.SUB;
    }

    public Funcion(LocalDateTime fecha, Formato formato, Idioma idioma, Pelicula pelicula, Sala sala) {
        this.fecha = fecha;
        this.formato = formato;
        this.idioma = idioma;
        this.pelicula = pelicula;
        this.sala = sala;
    }

    //Verifica si la funcion es en el mismo dia y despues de la hora del parametro
    public boolean esDespuesDe(LocalDateTime fechaActual) {
        return this.fecha.isAfter(fechaActual);
    }

    public boolean esEnMismoDia(LocalDateTime fecha) {
        if (this.fecha.getYear() == fecha.getYear()
                && this.fecha.getDayOfYear() == fecha.getDayOfYear()) {
            return true;
        } else {
            return false;
        }
    }
    

    public boolean esDoblada() {
        return this.idioma == Idioma.DOB;
    }

    public boolean esSubtitulada() {
        return this.idioma == Idioma.SUB;
    }

    public boolean esEn3D() {
        return this.formato == Formato.TRES_D;
    }

    public boolean esEn2D() {
        return this.formato == Formato.DOS_D;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

}
