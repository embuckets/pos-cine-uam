///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dominio;
//
//import java.time.Duration;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.Month;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author emilio
// */
//public class FuncionTest {
//    Funcion funcionTested;
//    Pelicula peliculaTested;
//    Sala salaTested;
//    LocalDateTime dateTested;
//    
//    
//    public FuncionTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//        dateTested = LocalDateTime.of(2018, Month.JUNE, 26, 13, 30);
//        peliculaTested = new Pelicula("Jurasic World", Duration.ofMinutes(123), Pelicula.Clasificacion.AA);
//        salaTested = new Sala("1", Sala.Tipo.TRADICIONAL);
//        funcionTested = new Funcion(dateTested, peliculaTested, salaTested);
//        
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of esDespuesDe method, of class Funcion.
//     */
//    @Test
//    public void testEsDespuesDe() {
//        LocalDateTime after = LocalDateTime.of(2018, Month.JUNE, 26, 13, 31);
//        boolean result = funcionTested.esDespuesDe(after);
//        assertFalse(result);
//        LocalDateTime before = LocalDateTime.of(2018, Month.JUNE, 26, 13, 0);
//        result = funcionTested.esDespuesDe(before);
//        assertTrue(result);
//        LocalDateTime dayAfter = LocalDateTime.of(2018, Month.JUNE, 27, 13, 30);
//        result = funcionTested.esDespuesDe(dayAfter);
//        assertFalse(result);
//        LocalDateTime mismo = LocalDateTime.of(2018, Month.JUNE, 26, 13, 30);
//        result = funcionTested.esDespuesDe(mismo);
//        assertFalse(result);
//    }
//    
//    @Test
//    public void testEsEnMismoDia() {
//        LocalDateTime aMinuteAfter = LocalDateTime.of(2018, Month.JUNE, 26, 13, 31);
//        boolean result = funcionTested.esEnMismoDia(aMinuteAfter);
//        assertTrue(result);
//        LocalDateTime halfHourBefore = LocalDateTime.of(2018, Month.JUNE, 26, 13, 0);
//        result = funcionTested.esEnMismoDia(halfHourBefore);
//        assertTrue(result);
//        LocalDateTime aDayAfter = LocalDateTime.of(2018, Month.JUNE, 27, 13, 30);
//        result = funcionTested.esEnMismoDia(aDayAfter);
//        assertFalse(result);
//        LocalDateTime sameDayAndTime = LocalDateTime.of(2018, Month.JUNE, 26, 13, 30);
//        result = funcionTested.esEnMismoDia(sameDayAndTime);
//        assertTrue(result);
//    }
////
////    /**
////     * Test of getFecha method, of class Funcion.
////     */
////    @Test
////    public void testGetFecha() {
////        System.out.println("getFecha");
////        Funcion instance = null;
////        LocalDateTime expResult = null;
////        LocalDateTime result = instance.getFecha();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of setFecha method, of class Funcion.
////     */
////    @Test
////    public void testSetFecha() {
////        System.out.println("setFecha");
////        LocalDateTime fecha = null;
////        Funcion instance = null;
////        instance.setFecha(fecha);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of getFormato method, of class Funcion.
////     */
////    @Test
////    public void testGetFormato() {
////        System.out.println("getFormato");
////        Funcion instance = null;
////        Funcion.Formato expResult = null;
////        Funcion.Formato result = instance.getFormato();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of setFormato method, of class Funcion.
////     */
////    @Test
////    public void testSetFormato() {
////        System.out.println("setFormato");
////        Funcion.Formato formato = null;
////        Funcion instance = null;
////        instance.setFormato(formato);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of getIdioma method, of class Funcion.
////     */
////    @Test
////    public void testGetIdioma() {
////        System.out.println("getIdioma");
////        Funcion instance = null;
////        Funcion.Idioma expResult = null;
////        Funcion.Idioma result = instance.getIdioma();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of setIdioma method, of class Funcion.
////     */
////    @Test
////    public void testSetIdioma() {
////        System.out.println("setIdioma");
////        Funcion.Idioma idioma = null;
////        Funcion instance = null;
////        instance.setIdioma(idioma);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of getPelicula method, of class Funcion.
////     */
////    @Test
////    public void testGetPelicula() {
////        System.out.println("getPelicula");
////        Funcion instance = null;
////        Pelicula expResult = null;
////        Pelicula result = instance.getPelicula();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of setPelicula method, of class Funcion.
////     */
////    @Test
////    public void testSetPelicula() {
////        System.out.println("setPelicula");
////        Pelicula pelicula = null;
////        Funcion instance = null;
////        instance.setPelicula(pelicula);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of getSala method, of class Funcion.
////     */
////    @Test
////    public void testGetSala() {
////        System.out.println("getSala");
////        Funcion instance = null;
////        Sala expResult = null;
////        Sala result = instance.getSala();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of setSala method, of class Funcion.
////     */
////    @Test
////    public void testSetSala() {
////        System.out.println("setSala");
////        Sala sala = null;
////        Funcion instance = null;
////        instance.setSala(sala);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////    
//}
