/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Funcion;
import dominio.Pelicula;
import dominio.Sala;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
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
public class FactoryTest {
    
    public FactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of creaNombreCine method, of class Factory.
     */
//    @Test
//    public void testCreaNombreCine() {
//        System.out.println("creaNombreCine");
//        String expResult = "";
//        String result = Factory.creaNombreCine();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }

    /**
     * Test of creaMapaDelDia method, of class Factory.
     */
    @Test
    public void testCreaMapaDelDia() {
        System.out.println("creaMapaDelDia");
        System.out.println(Factory.creaMapaDelDia(LocalDate.now()));
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of creaFunciones method, of class Factory.
     */
    @Test
    public void testCreaFunciones() {
        System.out.println("creaFunciones");
        List<Funcion> funciones = Factory.creaFunciones(Factory.PELICULAS[0], Factory.SALAS[0], LocalDate.now());
        System.out.println(funciones);
    }
    
}
