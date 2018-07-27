/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import persistencia.Factory;

/**
 *
 * @author emilio
 */
public class Cine {

    private static final String nombre;
    private static final Map<LocalDate, ProgramaDelDia> programa;

    static {
        nombre = Factory.NOMBRE_CINE;
        programa = new HashMap<>();
        programa.put(LocalDate.now(), new ProgramaDelDia(LocalDate.now()));
        programa.put(LocalDate.now().plusDays(1), new ProgramaDelDia(LocalDate.now().plusDays(1)));
        //TODO: Llenar hasmap para dos o tre dias
    }

    public static List<String> getDias() {
        return programa.keySet().stream().sorted().map(LocalDate::toString).collect(Collectors.toList());
    }

    public static Map<Pelicula, List<Funcion>> getFunciones() {
        return programa.get(LocalDate.now()).getTodasLasFunciones(LocalTime.now());
    }

    public static Map<Pelicula, List<Funcion>> getFunciones(LocalDate dia) {
        if (dia.isAfter(LocalDate.now())) {
            return programa.get(dia).getTodasLasFunciones();
        } else {
            return programa.get(LocalDate.now()).getTodasLasFunciones(LocalTime.now());
        }
    }

}
