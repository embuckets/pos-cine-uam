/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emilio
 */
public class ProgramaDelDiaTest {

    ProgramaDelDia programaDelDiaTested;
    Pelicula peliculaTested;
    Funcion funcionTested;
    Sala salaTested;

    public ProgramaDelDiaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        programaDelDiaTested = new ProgramaDelDia(LocalDate.now());
        peliculaTested = new Pelicula("Oceans 8", Duration.ofMinutes(120), Pelicula.Clasificacion.AA);
        salaTested = new Sala("1", Sala.Tipo.VIP);
        funcionTested = new Funcion(LocalDateTime.now(), peliculaTested, salaTested);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of agregarPelicula method, of class ProgramaDelDia.
     */
    @Test
    public void testAgregarPelicula() {
        System.out.println("agregarPelicula");
        boolean result = programaDelDiaTested.agregarPelicula(peliculaTested);
        assertTrue(result);
        result = programaDelDiaTested.agregarPelicula(peliculaTested);
        assertFalse(result);
        Pelicula otraPelicula = new Pelicula("Otro nombre", Duration.ofSeconds(130), Pelicula.Clasificacion.C);
        result = programaDelDiaTested.agregarPelicula(otraPelicula);
        assertTrue(result);

    }

    /**
     * Test of agregarFuncionAPelicula method, of class ProgramaDelDia.
     */
    @Test
    public void testAgregarFuncionAPelicula() {
        System.out.println("agregarFuncionAPelicula");

        programaDelDiaTested.agregarFuncion(funcionTested);
        List<Funcion> listaEsperada = new ArrayList<Funcion>();
        listaEsperada.add(funcionTested);
        List<Funcion> listaDevuelta = programaDelDiaTested.getFuncionesDePelicula(peliculaTested);
        assertEquals(listaEsperada, listaDevuelta);

        Funcion nuevaFuncion = new Funcion(LocalDateTime.now().plusDays(1), peliculaTested, salaTested);
        programaDelDiaTested.agregarFuncion(nuevaFuncion);
        listaDevuelta = programaDelDiaTested.getFuncionesDePelicula(peliculaTested);
        assertNotEquals(listaEsperada, listaDevuelta);
    }

    @Test
    public void testGetPeliculas() {
        programaDelDiaTested.agregarFuncion(funcionTested);
        List<Pelicula> todasLasPelicula = programaDelDiaTested.getPeliculas();
        System.out.println(Arrays.toString(todasLasPelicula.toArray()));
    }

    /**
     * Test of getFuncionesDePelicula method, of class ProgramaDelDia.
     */
    @Test
    public void testGetFuncionesDePelicula() {
//        System.out.println("getFuncionesDePelicula");
//        Pelicula pelicula = null;
//        ProgramaDelDia instance = null;
//        List<Funcion> expResult = null;
//        List<Funcion> result = instance.getFuncionesDePelicula(pelicula);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTodasLasFunciones() {
        Pelicula pelicula1 = new Pelicula("pelicula 1", Duration.ofMinutes(120), Pelicula.Clasificacion.AA);
        Pelicula pelicula2 = new Pelicula("pelicula 2", Duration.ofMinutes(120), Pelicula.Clasificacion.AA);
        Sala sala1 = salaTested;
        Sala sala2 = new Sala("2", Sala.Tipo.TRADICIONAL);

        Funcion funcion1Pelicula1 = new Funcion(LocalDateTime.now(), pelicula1, sala1);
        Funcion funcion2Pelicula1 = new Funcion(LocalDateTime.now().plusMinutes(120), pelicula1, sala1);

        Funcion funcion1Pelicula2 = new Funcion(LocalDateTime.now().plusMinutes(320), pelicula2, sala1);
        Funcion funcion2Pelicula2 = new Funcion(LocalDateTime.now(), pelicula2, sala2);

        List<Funcion> listaDeFunciones = new ArrayList<Funcion>();
        listaDeFunciones.add(funcion1Pelicula1);
        listaDeFunciones.add(funcion2Pelicula1);
        listaDeFunciones.add(funcion1Pelicula2);
        listaDeFunciones.add(funcion2Pelicula2);

        listaDeFunciones.stream().forEach(funcion -> programaDelDiaTested.agregarFuncion(funcion));

        Map<Pelicula, List<Funcion>> todasLasFunciones = programaDelDiaTested.getTodasLasFunciones();
        Set<Pelicula> todasLasPeliculas = todasLasFunciones.keySet();
        System.out.println(todasLasFunciones.toString());

    }
}
