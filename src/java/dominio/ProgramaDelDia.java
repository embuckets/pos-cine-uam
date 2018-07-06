/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author emilio
 */
public class ProgramaDelDia {

    private LocalDate fecha;

    private Map<Pelicula, List<Funcion>> funciones;

    public ProgramaDelDia(LocalDate fecha, Map<Pelicula, List<Funcion>> funciones) {
        this.fecha = fecha;
        this.funciones = funciones;
    }

    public ProgramaDelDia(LocalDate fecha) {
        this.fecha = fecha;
        this.funciones = new HashMap<Pelicula, List<Funcion>>();
    }

    /**
     * Agrega la pelicula si no existe
     *
     * @return true si la pelicula no existe
     */
    public boolean agregarPelicula(Pelicula pelicula) {
        if (!funciones.containsKey(pelicula)) {
            funciones.put(pelicula, null);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Agrega la funciona a las funciones de pelicula. Si la pelicula no existe
     * se agrega junto con la funcion.
     *
     * @param pelicula pelicula a la cual se quiere agregar una nueva funcion
     * @param funcion nueva funcion de pelicula
     */
    public void agregarFuncionAPelicula(Pelicula pelicula, Funcion funcion) {
        List<Funcion> funcionesDePelicula;
        if ((funcionesDePelicula = funciones.get(pelicula)) == null) {
            funcionesDePelicula = new ArrayList<Funcion>();
            funcionesDePelicula.add(funcion);
            funciones.put(pelicula, funcionesDePelicula);
        } else {
            funcionesDePelicula.add(funcion);
            funciones.put(pelicula, funcionesDePelicula);
        }
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

}
