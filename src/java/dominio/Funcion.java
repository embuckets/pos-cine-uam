/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author emilio
 */
public class Funcion implements Comparable<Funcion> {

    public static enum Formato {
        DOS_D, TRES_D
    }

    public static enum Idioma {
        DOB, SUB
    }
    
    private final int id;
    private final Formato formato;
    private final Idioma idioma;
    private final Pelicula pelicula;
    private final Sala sala;
    private final LocalDateTime hora; //deberia ser solo LocalDateTime

    public Funcion(LocalDateTime fecha, Pelicula pelicula, Sala sala) {
//        this.hora = LocalDateTime.of(fecha.getYear(), fecha.getMonth(), fecha.getDayOfMonth(), fecha.getHour(), fecha.getMinute());
        this.hora = LocalDateTime.of(fecha.toLocalDate(), fecha.toLocalTime().truncatedTo(ChronoUnit.MINUTES));
        this.pelicula = pelicula;
        this.sala = sala;
        this.formato = Formato.DOS_D;
        this.idioma = Idioma.SUB;
        this.id = hashCode();
    }

    public Funcion(LocalDateTime fecha, Formato formato, Idioma idioma, Pelicula pelicula, Sala sala) {
//        this.hora = LocalDateTime.of(fecha.getYear(), fecha.getMonth(), fecha.getDayOfMonth(), fecha.getHour(), fecha.getMinute());
        this.hora = LocalDateTime.of(fecha.toLocalDate(), fecha.toLocalTime().truncatedTo(ChronoUnit.MINUTES));
        this.formato = formato;
        this.idioma = idioma;
        this.pelicula = pelicula;
        this.sala = sala;
        this.id = hashCode();
    }
    
    public int getId(){
        return this.id;
    }
    

    public String getHoraYMinuto() {

        return DateTimeFormatter.ofPattern("HH:mm").format(this.hora);
    }

    @Override
    public String toString() {
        return "Funcion{" + "fecha=" + hora + ", formato=" + formato + ", idioma=" + idioma + ", pelicula=" + pelicula + ", sala=" + sala + '}';
    }

    /**
     * Ordena la Funcion primero por nombre y despues por hora.
     *
     * @param t
     * @return
     */
    @Override
    public int compareTo(Funcion t) {
        int comparacion;
        if ((comparacion = this.pelicula.getNombre().compareToIgnoreCase(t.getPelicula().getNombre())) == 0) {
            return this.hora.compareTo(t.getHora());
        } else {
            return comparacion;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(hora.toString(), sala, pelicula);
//        return Objects.hash(hora, formato, idioma, pelicula, sala);
//        int hash = 7;
//        hash = 79 * hash + Objects.hashCode(this.hora);
//        hash = 79 * hash + Objects.hashCode(this.formato);
//        hash = 79 * hash + Objects.hashCode(this.idioma);
//        hash = 79 * hash + Objects.hashCode(this.pelicula);
//        hash = 79 * hash + Objects.hashCode(this.sala);
//        return hash;
    }

    /**
     * Son iguales si la hora, pelicula y sala son iguales. Se verifica la
     * igualdad llamando al metodo equals de hora pelicula y sala. Los demas
     * parametros no se toman en cuenta
     *
     * @param obj
     * @return true si la hora, pelicula y sala son iguales
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
        final Funcion other = (Funcion) obj;
        if (this.hora.compareTo(other.hora) != 0) {
            return false;
        }
        if (!this.pelicula.equals(other.pelicula)) {
            return false;
        }
        if (!this.sala.equals(other.sala)) {
            return false;
        }
        return true;
    }

    //Verifica si la funcion es en el mismo dia y despues de la hora del parametro
    public boolean esDespuesDe(LocalDateTime fechaActual) {
        return this.hora.isAfter(fechaActual);
    }

//    public boolean esEnMismoDia(LocalDateTime hora) {
//        if (this.hora.getYear() == hora.getYear()
//                && this.hora.getDayOfYear() == hora.getDayOfYear()) {
//            return true;
//        } else {
//            return false;
//        }
//    }
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

    public LocalDateTime getHora() {
        return hora;
    }

//    private void setFecha(LocalDateTime hora) {
//        this.hora = hora;
//    }
    public Formato getFormato() {
        return formato;
    }

//    public void setFormato(Formato formato) {
//        this.formato = formato;
//    }
    public Idioma getIdioma() {
        return idioma;
    }

//    public void setIdioma(Idioma idioma) {
//        this.idioma = idioma;
//    }
    public Pelicula getPelicula() {
        return pelicula;
    }

//    public void setPelicula(Pelicula pelicula) {
//        this.pelicula = pelicula;
//    }
    public Sala getSala() {
        return sala;
    }

//    public void setSala(Sala sala) {
//        this.sala = sala;
//    }
}
