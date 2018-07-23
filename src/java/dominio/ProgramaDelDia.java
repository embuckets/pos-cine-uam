/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.event.ListSelectionEvent;
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

//    static {
//        fecha = Factory.creaFechaDeHoy();
//        funciones = Factory.creaMapaDelDia();
//    }
    public ProgramaDelDia(LocalDate dia) {
        this.fecha = dia;
        this.funciones = Factory.creaMapaDelDia(dia);

    }

//    public ProgramaDelDia(LocalDate fecha, Map<Pelicula, List<Funcion>> funciones) {
//        this.fecha = fecha;
//        this.funciones = funciones;
//    }
//    public ProgramaDelDia(LocalDate fecha) {
//        this.fecha = fecha;
//        this.funciones = new HashMap<Pelicula, List<Funcion>>();
//    }
    /**
     * TODO: Esta clase solo deberia preocuparse solo de guardar funciones no de
     * peliculas sin funciones. Agrega la pelicula si no existe
     *
     * @return true si la pelicula no existe
     */
//    public boolean agregarPelicula(Pelicula pelicula) {
//        if (!funciones.containsKey(pelicula)) {
//            funciones.put(pelicula, null);
//            return true;
//        } else {
//            return false;
//        }
//    }

//    public void agregarFuncion(Pelicula pelicula, LocalTime hora, Sala sala, Funcion.Formato formato, Funcion.Idioma idioma) {
//        if (this.funciones.containsKey(pelicula)) {
//            List<Funcion> funcionesDeLaPelicula = this.funciones.get(pelicula);
//            funcionesDeLaPelicula.add(new Funcion(LocalTime.of(hora.getHour(), hora.getMinute()), formato, idioma, pelicula, sala));
//        }
//    }

    /**
     * Agrega la funcion al programa del dia. Si la pelicula de la funcion no
     * existe se agrega junto con la funcion. Si ya existe se agrega la funcion
     * a las funciones existentes.
     *
     * @param funcion
     * @return
     */
//    public boolean agregarFuncion(Funcion funcion) {
//        if (!funciones.containsKey(funcion.getPelicula())) {
//            List<Funcion> nuevaLista = new ArrayList<Funcion>();
//            nuevaLista.add(funcion);
//            funciones.put(funcion.getPelicula(), nuevaLista);
//            return true;
//        } else {
//            List<Funcion> listaActual = funciones.get(funcion.getPelicula());
//            listaActual.add(funcion);
//            funciones.put(funcion.getPelicula(), listaActual);
//            return true;
//        }
//    }

//    /**
//     * ERROR: no checa si la la pelicula en la funcion es igual al parametro
//     * pelicula Agrega la funciona a las funciones de pelicula, Mejor usar agregarFuncion. Si la pelicula
//     * no existe se agrega junto con la funcion.
//     *
//     * @param pelicula pelicula a la cual se quiere agregar una nueva funcion
//     * @param funcion nueva funcion de pelicula
//     */
//    public void agregarFuncionAPelicula(Pelicula pelicula, Funcion funcion) {
//        List<Funcion> funcionesDePelicula;
//        if ((funcionesDePelicula = funciones.get(pelicula)) == null) {
//            funcionesDePelicula = new ArrayList<Funcion>();
//            funcionesDePelicula.add(funcion);
//            funciones.put(pelicula, funcionesDePelicula);
//        } else {
//            funcionesDePelicula.add(funcion);
//            funciones.put(pelicula, funcionesDePelicula);
//        }
//    }
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
//        return Arrays.asList(funciones.keySet().toArray());
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
