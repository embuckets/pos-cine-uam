/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

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
public class AsientoTest {
    Asiento asientoTest;
    
    
    public AsientoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        asientoTest = new Asiento("A", "1");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Asiento.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Asiento instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Asiento.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Asiento instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Asiento.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Asiento instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFila method, of class Asiento.
     */
    @Test
    public void testGetFila() {
        System.out.println("getFila");
        Asiento instance = null;
        String expResult = "";
        String result = instance.getFila();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFila method, of class Asiento.
     */
    @Test
    public void testSetFila() {
        System.out.println("setFila");
        String expected = "A";
        asientoTest.setFila(expected);
        String result = asientoTest.getFila();
        assertEquals(expected, result);
        asientoTest.setFila("NO");
        
    }

    /**
     * Test of getNumero method, of class Asiento.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        String expected = "1";
        String result = asientoTest.getNumero();
        assertEquals(expected, result);
    }

    /**
     * Test of setNumero method, of class Asiento.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        String expected = "10";
        asientoTest.setNumero("10");
        String result = asientoTest.getNumero();
        assertEquals(expected, result);
    }
    
}
