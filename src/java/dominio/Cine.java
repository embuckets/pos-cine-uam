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
 *
 * @author emilio
 */
public class Cine {

    private final String nombre;
    private final Programa programa;

    //private Direccion direccion;
    public Cine(String nombre) {
        this.nombre = nombre;
        this.programa = new Programa();
    }

    public Cine(String nombre, Programa programa) {
        this.nombre = nombre;
        this.programa = programa;
    }

    public Map<Pelicula, List<Funcion>> getFunciones(LocalDate fecha) throws FechaException {
        try {
            Map<Pelicula, List<Funcion>> funciones = programa.getFuncionesDelDia(fecha);
            return funciones;

        } catch (FechaException e) {
            throw new FechaException();
        }
//        Optional<ProgramaDelDia> programaDelDia = programa.getFuncionesDelDia(fecha);
//        if (programaDelDia.isPresent()) {
//            final ProgramaDelDia pro = programaDelDia.get();
//        }

    }

}
