/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import persistencia.Factory;

/**
 *
 * @author emilio
 */
public class Cine {

    private static final String nombre;
    private static final Map<LocalDate, ProgramaDelDia> programa;
//    private static final ProgramaDelDia programa;

    static {
        nombre = Factory.NOMBRE_CINE;
        programa = new HashMap<>();
        programa.put(LocalDate.now(), new ProgramaDelDia(LocalDate.now()));
        programa.put(LocalDate.now().plusDays(1), new ProgramaDelDia(LocalDate.now().plusDays(1)));
        //TODO: Llenar hasmap para dos o tre dias
    }

    public static List<String> getDias() {
//        return programa.keySet().stream().map(LocalDate::toString).collect(Collectors.toList());
        return programa.keySet().stream().sorted().map(LocalDate::toString).collect(Collectors.toList());

    }

    //private Direccion direccion;
//    public Cine(String nombre) {
//        this.nombre = nombre;
//        this.programa = new Programa();
//    }
//
//    public Cine(String nombre, Programa programa) {
//        this.nombre = nombre;
//        this.programa = programa;
//    }
//    public Map<Pelicula, List<Funcion>> getFunciones(LocalDate fecha) throws FechaException {
//        return this.programa.get(fecha).getTodasLasFunciones();
//        try {
//            Map<Pelicula, List<Funcion>> funciones = programa.getFuncionesDelDia(fecha);
//            return funciones;
//
//        } catch (FechaException e) {
//            throw new FechaException();
//        }
//        Optional<ProgramaDelDia> programaDelDia = programa.getFuncionesDelDia(fecha);
//        if (programaDelDia.isPresent()) {
//            final ProgramaDelDia pro = programaDelDia.get();
//        }
//    }

    public static Map<Pelicula, List<Funcion>> getFunciones() {
        return programa.get(LocalDate.now()).getTodasLasFunciones();
    }
    
    public static Map<Pelicula, List<Funcion>> getFunciones(LocalDate dia) {
        return programa.get(dia).getTodasLasFunciones();
    }
    
    

    public static Map<String, String[]> getFuncionesString() {
        Map<String, String[]> result = new HashMap<>();
        ProgramaDelDia programaDelDia = programa.get(LocalDate.now());
        List<Pelicula> peliculas = programaDelDia.getPeliculas();
        for (Pelicula pelicula : peliculas) {
            List<Funcion> funcionesList = programaDelDia.getFuncionesDePelicula(pelicula);
            List<String> funcionesString = funcionesList.stream().map(Funcion::getHoraYMinuto).collect(Collectors.toList());
            String[] strings = funcionesString.toArray(new String[funcionesString.size()]);
            result.put(pelicula.getNombre(), strings);
        }
        return result;
    }

    public static Map<String, String[]> getFuncionesString(LocalDate dia) {
        Map<String, String[]> result = new HashMap<>();
        ProgramaDelDia programaDelDia = programa.get(dia);
        List<Pelicula> peliculas = programaDelDia.getPeliculas();
        for (Pelicula pelicula : peliculas) {
            List<Funcion> funcionesList = programaDelDia.getFuncionesDePelicula(pelicula);
            List<String> funcionesString = funcionesList.stream().map(Funcion::getHoraYMinuto).collect(Collectors.toList());
            String[] strings = funcionesString.toArray(new String[funcionesString.size()]);
            result.put(pelicula.getNombre(), strings);
        }
        return result;
    }

}
