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
import java.util.Collections;
import java.util.List;
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
    Sala saltaTested;

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
        Sala sala = new Sala("1", Sala.Tipo.VIP);
        funcionTested = new Funcion(LocalDateTime.now(), peliculaTested, saltaTested);
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
        
        programaDelDiaTested.agregarFuncionAPelicula(peliculaTested, funcionTested);
        List<Funcion> listaEsperada = new ArrayList<Funcion>();
        listaEsperada.add(funcionTested);
        List<Funcion> listaDevuelta = programaDelDiaTested.getFuncionesDePelicula(peliculaTested);
        assertEquals(listaEsperada, listaDevuelta);
        
        Funcion nuevaFuncion = new Funcion(LocalDateTime.now().plusDays(1), peliculaTested, saltaTested);
        programaDelDiaTested.agregarFuncionAPelicula(peliculaTested, nuevaFuncion);
        listaDevuelta = programaDelDiaTested.getFuncionesDePelicula(peliculaTested);
        assertNotEquals(listaEsperada, listaDevuelta);
        
        
        

//        Pelicula pelicula = null;
//        Funcion funcion = null;
//        ProgramaDelDia instance = null;
//        boolean expResult = false;
//        boolean result = instance.agregarFuncionAPelicula(pelicula, funcion);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
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

}
