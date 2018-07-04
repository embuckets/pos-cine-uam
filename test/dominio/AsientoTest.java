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

    Asiento asientoTested;

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
        asientoTested = new Asiento('A', 1);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setFila method, of class Asiento.
     */
    @Test
    public void testSetFila() {
        System.out.println("setFila");
        try {
            asientoTested.setFila('A');
        } catch (IllegalArgumentException e) {
            fail("Caracter 'A' deberia ser valido");
        }
        try {
            asientoTested.setFila('a');
        } catch (IllegalArgumentException e) {
            fail("Caracter 'a' deberia ser valido");
        }
        try {
            asientoTested.setFila(Character.MIN_VALUE);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue("Character.MIN_VALUE no deberia ser valido", true);
        }
        try {
            asientoTested.setFila('ñ');
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue("Caracter ñ no deberia ser valido", true);
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNumero method, of class Asiento.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        try {
            asientoTested.setNumero(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue("0 no es un valor valido", true);
        }
        try {
            asientoTested.setNumero(-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue("-1 no es un valor valido", true);
        }
        try {
            asientoTested.setNumero(30);
        } catch (IllegalArgumentException e) {
            fail("30 es un valor valido");
        }
        try {
            asientoTested.setNumero(31);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue("31 no es un valor valido", true);
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testConstructor() {
        try {
            asientoTested = new Asiento('7', 7);

        } catch (IllegalArgumentException e) {
            assertTrue("Caracter 7 no es una fila valida", true);
        }

    }

}
