/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import persistencia.Factory;

/**
 * NOTES: Esta clase debe ser la encargada de crear las funciones para evitar
 * errores en la fecha
 */
/**
 *
 * @author emilio
 */
public class ProgramaDelDia {

    private final LocalDate fecha;
    private final Map<Pelicula, List<Funcion>> funciones;

    public ProgramaDelDia(LocalDate dia) {
        this.fecha = dia;
        this.funciones = Factory.creaMapaDelDia(dia);

    }

    /**
     * Regresa la lista de funciones de la pelicula
     *
     * @param pelicula pelicula de la cual se quieren sus funciones
     * @return la lista de las funciones de la pelicula. Regresa una lista vacia
     * si la pelicula no existe
     */
    public List<Funcion> getFuncionesDePelicula(Pelicula pelicula) {
        List<Funcion> funcionesDePelicula;
        if ((funcionesDePelicula = this.funciones.get(pelicula)) != null) {
            return funcionesDePelicula;
        } else {
            return Collections.emptyList();
        }
    }

    public List<Pelicula> getPeliculas() {
        return Collections.unmodifiableList(funciones.keySet().stream().collect(Collectors.toList()));
    }

    public LocalDate getFecha() {
        return fecha;
    }

    /**
     *
     * @return Regresa un mapa inmodificable
     */
    public Map<Pelicula, List<Funcion>> getTodasLasFunciones() {
        return Collections.unmodifiableMap(this.funciones);
    }

}
