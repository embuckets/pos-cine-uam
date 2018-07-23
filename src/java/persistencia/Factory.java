/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Cine;
import dominio.Funcion;
import dominio.Pelicula;
import dominio.ProgramaDelDia;
import dominio.Sala;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author emilio
 */
public class Factory {
    
    public static Sala[] SALAS = new Sala[]{
            new Sala("1", Sala.Tipo.TRADICIONAL, 12, 20),
            new Sala("2", Sala.Tipo.TRADICIONAL, 10, 20),
            new Sala("3", Sala.Tipo.TRADICIONAL, 15, 25),
            new Sala("4", Sala.Tipo.TRADICIONAL, 8, 10),
            new Sala("5", Sala.Tipo.TRADICIONAL, 13, 16)
        };
    
    public static Pelicula[] PELICULAS = new Pelicula[]{
            new Pelicula("Ant-Man and the Wasp", Duration.ofMinutes(118), Pelicula.Clasificacion.B),
            new Pelicula("Jurassic World: El Reino Caido", Duration.ofMinutes(128), Pelicula.Clasificacion.B),
            new Pelicula("Los Increibles 2", Duration.ofMinutes(124), Pelicula.Clasificacion.A),
            new Pelicula("Ocean's 8: Las Estafadoras", Duration.ofMinutes(110), Pelicula.Clasificacion.B),
            new Pelicula("Sicario 2: Soldado", Duration.ofMinutes(122), Pelicula.Clasificacion.B15)
        };
    
    public static String NOMBRE_CINE = "Cine Uam Azc";
    
    
    

//    public static Cine creaCine() {
//        //TODO 
//    }
//    public static String creaNombreCine() {
//        return "Cine Uam Azcapo";
//    }

//    public static Programa creaPrograma(){
//        //TODO
//    }
//    public static Map<LocalDate, ProgramaDelDia> creaProgama() {
//        //TODO
//    }
    
    

    public static Map<Pelicula, List<Funcion>> creaMapaDelDia(LocalDate dia) {
        Map<Pelicula, List<Funcion>> result = new HashMap<>();
        for (int i = 0 ; i < PELICULAS.length; i++){
            List<Funcion> funciones = creaFunciones(PELICULAS[i], SALAS[i], dia);
            result.put(PELICULAS[i], funciones);
        }
//        List<Pelicula> peliculas = creaPeliculas();
//        List<Sala> salas = creaSalas();
//        int i = 0;
//        for (Pelicula pelicula : peliculas) {
//            List<Funcion> funcioneList = creaFunciones(pelicula, salas.get(i));
//            result.put(pelicula, funcioneList);
//            i = (i++) % salas.size();
//        }
        return result;
    }
//
//    public static LocalDate creaFechaDeHoy() {
//        return LocalDate.now();
//    }

//    public static List<Pelicula> creaPeliculas() {
//        Pelicula[] peliculasArray = new Pelicula[]{
//            new Pelicula("Ant-Man and the Wasp", Duration.ofMinutes(118), Pelicula.Clasificacion.B),
//            new Pelicula("Jurassic World: El Reino Caido", Duration.ofMinutes(128), Pelicula.Clasificacion.B),
//            new Pelicula("Los Increibles 2", Duration.ofMinutes(124), Pelicula.Clasificacion.A),
//            new Pelicula("Ocean's 8: Las Estafadoras", Duration.ofMinutes(110), Pelicula.Clasificacion.B),
//            new Pelicula("Sicario 2: Soldado", Duration.ofMinutes(122), Pelicula.Clasificacion.B15)
//        };
//        List<Pelicula> peliculasList = new ArrayList<>();
//        for (Pelicula pelicula : peliculasArray) {
//            peliculasList.add(pelicula);
//        }
//        return Collections.unmodifiableList(peliculasList);
//    }

//    public static List<Sala> creaSalas() {
//        Sala[] salasArray = new Sala[]{
//            new Sala("1", Sala.Tipo.TRADICIONAL, 12, 20),
//            new Sala("2", Sala.Tipo.TRADICIONAL, 10, 20),
//            new Sala("3", Sala.Tipo.TRADICIONAL, 15, 25),
//            new Sala("4", Sala.Tipo.VIP, 8, 10),
//            new Sala("4", Sala.Tipo.MACRO_XE, 13, 16)
//        };
//        List<Sala> salasList = new ArrayList<Sala>();
//        for (Sala sala : salasArray) {
//            salasList.add(sala);
//        }
//        return Collections.unmodifiableList(salasList);
//    }

    public static List<Funcion> creaFunciones(Pelicula pelicula, Sala sala, LocalDate fecha) {
        List<Funcion> resultado = new ArrayList<>();
        LocalDateTime horaApertura = LocalDateTime.of(fecha, LocalTime.of(10, 0));
        long offset = pelicula.getDuracion().toMinutes();
        offset = Math.floorDiv(offset, 10) * 10;
        Duration duracion = Duration.ofMinutes(offset);
        
        Funcion funcion0 = new Funcion(horaApertura, pelicula, sala);
        resultado.add(funcion0);
        for(int i = 1; i < 6; i ++){
            Funcion funcion = new Funcion(horaApertura.plusMinutes(duracion.toMinutes() * i), pelicula, sala);
            resultado.add(funcion);
        }
//        Funcion funcion1 = new Funcion(LocalTime.of(10, 0), pelicula, sala);
//        Funcion funcion2 = new Funcion(LocalTime.of(12, 30), pelicula, sala);
//        Funcion funcion3 = new Funcion(LocalTime.of(15, 0), pelicula, sala);
//        Funcion funcion4 = new Funcion(LocalTime.of(17, 30), pelicula, sala);
//        resultado.add(funcion1);
//        resultado.add(funcion2);
//        resultado.add(funcion3);
//        resultado.add(funcion4);
        return resultado;
    }

}
