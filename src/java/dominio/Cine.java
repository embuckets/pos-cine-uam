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
    private static final ProgramaDelDia programa;

    static {
        nombre = Factory.creaNombreCine();
        programa = new ProgramaDelDia();
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
    public Map<Pelicula, List<Funcion>> getFunciones(LocalDate fecha) throws FechaException {
        return this.programa.getTodasLasFunciones();
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

    }

    public static Map<String, String[]> getFuncionesString() {
        Map<String, String[]> result = new HashMap<>();
        List<Pelicula> peliculas = programa.getPeliculas();
        for (Pelicula pelicula : peliculas) {
            List<Funcion> funcionesList = programa.getFuncionesDePelicula(pelicula);
            List<String> funcionesString = funcionesList.stream().map(Funcion::getHoraYFecha).collect(Collectors.toList());
            String[] strings = funcionesString.toArray(new String[funcionesString.size()]);
            result.put(pelicula.getNombre(), strings);
        }
        return result;
    }

}
