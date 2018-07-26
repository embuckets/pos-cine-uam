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

/**
 * Encargado del control de las funciones de un cine
 *
 * @author emilio
 */
public class Programa {

//    private final Map<LocalDate, ProgramaDelDia> programa;
//
//    public Programa() {
//        programa = new HashMap<LocalDate, ProgramaDelDia>();
//    }
//
//    /**
//     * asigna programaDelDia al dia de ese programa si es que ese dia no ha sido
//     * registrado
//     *
//     * @param programaDelDia
//     * @return true si el el dia no tiene un programa.
//     */
//    public boolean agregarProgramaDelDia(ProgramaDelDia programaDelDia) {
//        final LocalDate fecha = programaDelDia.getFecha();
//        if (!programa.containsKey(fecha)) {
//            programa.put(fecha, programaDelDia);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public Map<Pelicula, List<Funcion>> getFuncionesDelDia(LocalDate fecha) throws FechaException {
//        if (programa.containsKey(fecha)) {
//            return programa.get(fecha).getTodasLasFunciones();
//        } else {
//            throw new FechaException();
//        }
//
////        if (programa.containsKey(fecha)) {
////            return Optional.of(programa.get(fecha));
////        } else {
////
////        }
//    }

}
