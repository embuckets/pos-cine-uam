/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
    private final LocalDateTime hora;

    public Funcion(LocalDateTime fecha, Pelicula pelicula, Sala sala) {
        this.hora = LocalDateTime.of(fecha.toLocalDate(), fecha.toLocalTime().truncatedTo(ChronoUnit.MINUTES));
        this.pelicula = pelicula;
        this.sala = sala;
        this.formato = Formato.DOS_D;
        this.idioma = Idioma.SUB;
        this.id = hashCode();
    }

    public Funcion(LocalDateTime fecha, Formato formato, Idioma idioma, Pelicula pelicula, Sala sala) {
        this.hora = LocalDateTime.of(fecha.toLocalDate(), fecha.toLocalTime().truncatedTo(ChronoUnit.MINUTES));
        this.formato = formato;
        this.idioma = idioma;
        this.pelicula = pelicula;
        this.sala = sala;
        this.id = hashCode();
    }

    public int getId() {
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

    public Formato getFormato() {
        return formato;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Sala getSala() {
        return sala;
    }

}
